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
## 2.学会使用查表法
1234
零零零壹贰叁肆
零佰零拾零万壹仟贰佰叁拾肆元
```java
public class Main {
    String str;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter an int:");
        String str = scanner.next();
        String originalString = addZero(toUppercase(str));
        System.out.println(originalString);
        String[] unit = {"佰","拾","万","仟","佰","拾","元"};
        String finalString = "";

        for (int i = 0; i < 7; i++) {
            finalString = finalString+originalString.charAt(i)+unit[i];

        }
        System.out.println(finalString);
    }

    public static String toUppercase(String str){
        // 学会使用查表法，即将数字跟表产生一个一一对应的关系
        String[] uppercase = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖",};
        String result = "";
        for(int i=0;i<str.length();i++){
            // main step
            // 这行代码首先使用charAt方法获取字符串中的第i个字符，然后通过减去字符'0'的ASCII值，将字符型的数字转换为整数。
            // 字符'2'的ASCII值是50，字符'0'的ASCII值是48，所以'2'-'0'的结果就是2，这就实现了字符到整数的转换
            int number = str.charAt(i)-'0';
            result = result+uppercase[number];
        }
        return result;
    }
    public static String addZero(String str){
        int count = 7-str.length();
        for (int i = 0; i < count; i++) {
            str = "零"+str;
        }
        return str;
    }
}
```