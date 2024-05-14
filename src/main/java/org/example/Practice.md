## 1.student
```java
public class Main {
    static StudentInfo[] students ;
    public static void main(String[] args) {
        students = new StudentInfo[3];

        StudentInfo student1 = new StudentInfo(1, "Alice", 20);
        StudentInfo student2 = new StudentInfo(2, "Bob", 21);
        StudentInfo student3 = new StudentInfo(3, "Charlie", 22);

        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        
        // add a new student and check if the student is already exist
        // if the student is already exist, print "this student is already exist"
        // if the student is not exist, add the student to the array
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter student ID");
            int stuID = scanner.nextInt();
            System.out.println("enter your name");
            String stuName = scanner.next();
            System.out.println("enter your age");
            int stuAge = scanner.nextInt();

            StudentInfo newStudent = new StudentInfo(stuID,stuName,stuAge);

            boolean flag = contains(students,newStudent.getId());

            if(flag){
                System.out.println("this student is already exist");
            }else{
                int existStudentNumber = count(students);
                if(existStudentNumber<students.length){
                    students[existStudentNumber] = newStudent;
                }else{
                    createNewArray(students);
                    students[existStudentNumber] = newStudent;
                }

            }
            // continue or quit
            System.out.println("enter 0 or 1 : 0 represent continue, 1 represent to quit");
            int command = scanner.nextInt();
            if(command==1){
                break;
            }
        }
        // print all students
        for(StudentInfo i : students){
            System.out.println(i.getId()+" "+i.getName()+" "+i.getAge());
        }
    }
    // check if the student is already exist
    public static boolean contains(StudentInfo[] array, int id){
        for(int i = 0;i<array.length;i++){
            int stdID = array[i].getId();
            if(stdID == id){
                return true;
            }
        }
        return false;
    }
    // count the number of students
    public static int count(StudentInfo[] array){
      int count = 0;
      for (StudentInfo i : array){
        if(i != null){
          count++;
        }
      }
      return count;
  
    }
    // create a new array if the array is full
    public static void createNewArray(StudentInfo[] array){
        StudentInfo[] newStudents = new StudentInfo[array.length+1];
        for(int i = 0;i < array.length;i++){
            newStudents[i] = array[i];
        }
        students = newStudents;
    }
    

}
```