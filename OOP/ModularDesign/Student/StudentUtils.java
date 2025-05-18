package Java_Bootcamp.OOP.ModularDesign.Student;

public class StudentUtils {

    public static double calculateAverage(Student s1){

        int[] marks = s1.getMarks();
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / (marks.length - 1);
    }

    public static boolean isPassed(Student s1){

        int[] marks = s1.getMarks();

        for (int mark : marks) {
            if(mark <= 35)
                return false;
        }

        return true;
    }

    public static String getStudentDetails(Student s1){

        return ("Name : " + s1.getName() + "\nAverage Mark: " + calculateAverage(s1) + "\nStatus: " + isPassed(s1));
    }
}
