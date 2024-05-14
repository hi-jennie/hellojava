package org.example;

import java.util.Random;
import java.util.Scanner;


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

        for(StudentInfo i : students){
            System.out.println(i.getId()+" "+i.getName()+" "+i.getAge());
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

}

