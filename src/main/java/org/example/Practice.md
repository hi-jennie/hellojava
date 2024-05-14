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

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("**add**, **delete**, **display**,**quit**");
            String choice = scanner.next();

            if(choice.equals("add")){
                addStudent();
            }
            if(choice.equals("delete")){
                deleteStudent1();
            }
            if(choice.equals("display")){
                for(StudentInfo i : students){
                    System.out.println(i.getId()+" "+i.getName()+" "+i.getAge());
                }
            }
            if(choice.equals("quit")){
                break;
            }
        }


    }

    public static boolean contains(StudentInfo[] array, int id){
        for(int i = 0;i<array.length;i++){
            int stdID = array[i].getId();
            if(stdID == id){
                return true;
            }
        }
        return false;
    }

    public static void createNewArray(StudentInfo[] array){
        StudentInfo[] newStudents = new StudentInfo[array.length+1];
        for(int i = 0;i < array.length;i++){
            newStudents[i] = array[i];
        }
        students = newStudents;
    }


    public static int count(StudentInfo[] array){
        int count = 0;
        for (StudentInfo i : array){
            if(i != null){
                count++;
            }
        }
        return count;

    }

    public static void addStudent(){
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

            System.out.println("enter 0 or 1 to continue : 0 represent continue, 1 represent to quit");
            int command = scanner.nextInt();
            if(command==1){
                break;
            }
        }

    }
    // input ID to get the index
    public static int getIndex(StudentInfo[] array,int ID){
        for(int i=0;i<array.length;i++){
            int stdID = array[i].getId();
            if(stdID==ID){
                return i;
            }
        }
        return -1;
    }
    public static void deleteStudent1(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("enter the student ID that you want to delete:");
            int ID = scanner.nextInt();
            boolean flag = contains(students,ID);
            if(flag){
                int index = getIndex(students,ID);
                int newLength = students.length-1;
                if(newLength>0){
                    StudentInfo[] newStudents = new StudentInfo[newLength];
                    // if
                    int j = 0;
                    for(int i = 0;i<students.length;i++){
                        if(i != index){
                            newStudents[j++] = students[i];
                        }
                    }
                    students = newStudents;
                }else{
                    System.out.println("all students are deleted");
                }
            }else{
                System.out.println("this student doesn't exist");
            }
            System.out.println("enter 0 or 1 to continue : 0 represent continue, 1 represent to quit");
            int command = scanner.nextInt();
            if(command==1){
                break;
            }
        }
    }

    public static void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("enter the student ID that you want to delete:");
            int ID = scanner.nextInt();
            boolean flag = contains(students,ID);
            if(flag){
                int index = getIndex(students,ID);
                int newLength = students.length-1;
                if(newLength>0){
                    StudentInfo[] newStudents = new StudentInfo[newLength];
                    for(int i = 0;i<students.length;i++){
                        if(students[i]!=students[index]){
                            newStudents[i] = students[i];
                        }
                    }
                    students = newStudents;
                }else{
                    System.out.println("all students are deleted");
                }
            }else{
                System.out.println("this student doesn't exist");
            }
            System.out.println("enter 0 or 1 to continue : 0 represent continue, 1 represent to quit");
            int command = scanner.nextInt();
            if(command==1){
                break;
            }
        }
    }



}
```