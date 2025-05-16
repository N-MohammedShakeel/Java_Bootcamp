package Java_Bootcamp.OOP.OOP_Design.Student;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        Student s1 = new Student();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        s1.setName(name);

        System.out.println("Enter no.of.subjects: ");
        int size = sc.nextInt();
        int[] marks = new int[size];
        System.out.println("Enter Marks");

        for (int i=0 ; i < marks.length ; i++){
            marks[i] = sc.nextInt();
        }

        s1.setName(name);
        s1.setMarks(marks);

        System.out.println(StudentUtils.getStudentDetails(s1));


    }
}
