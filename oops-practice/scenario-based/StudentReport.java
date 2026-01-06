import java.util.ArrayList;

public class StudentReport {

    public static void main(String[] args) {

        String[] subjects = { "Physics", "Chemistry", "Maths" };

        try {
            int[] marks1 = { 85, 90, 78 };
            validateMarks(marks1);
            displayReport("Amit", subjects, marks1);

            int[] marks2 = { 95, 88, 92 };
            validateMarks(marks2);
            displayReport("Neha", subjects, marks2);

            // Invalid marks case
            int[] marks3 = { 120, 70, 60 };
            validateMarks(marks3);
            displayReport("Rahul", subjects, marks3);

        } catch (InvalidMarkException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validateMarks(int[] marks)
            throws InvalidMarkException {

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException(
                        "Marks must be between 0 and 100");
            }
        }
    }

    public static double averageScore(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum / (double) scores.length;
    }

    public static char findGrade(double avg) {
        if (avg >= 90)
            return 'A';
        else if (avg >= 75)
            return 'B';
        else if (avg >= 60)
            return 'C';
        else
            return 'D';
    }

    static void displayReport(String name, String[] subjects, int[] marks) {

        double avg = averageScore(marks);
        char grade = findGrade(avg);

        System.out.println("\n--- Report Card ---");
        System.out.println("Name: " + name);

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }

        System.out.println("Average: " + avg);
        System.out.println("Grade  : " + grade);
    }
}

class InvalidMarkException extends Exception {
    InvalidMarkException(String msg) {
        super(msg);
    }
}
