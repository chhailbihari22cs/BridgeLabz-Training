import java.util.Scanner;

public class StudentTestScores {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[] marks = new double[n];
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            System.out.print("Enter marks of student " + (i + 1) + ": ");
            double value = sc.nextDouble();

            if (value < 0) {
                System.out.println("Invalid marks! Enter again.");
                i--;
                continue;
            }

            marks[i] = value;
            sum += value;

            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        double average = sum / n;

        System.out.println("\nAverage Marks : " + average);
        System.out.println("Maximum Marks : " + max);
        System.out.println("Minimum Marks : " + min);

        System.out.println("\nStudents scoring above average:");
        for (int i = 0; i < n; i++) {
            if (marks[i] > average) {
                System.out.println("Student " + (i + 1) + " -> " + marks[i]);
            }
        }

        sc.close();
    }
}
