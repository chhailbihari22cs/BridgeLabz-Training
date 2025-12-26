import java.util.Scanner;

public class QuadraticEquation {

    public static double[] computeRoots(double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - (4 * a * c);

        if (discriminant > 0) {
            double firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[] { firstRoot, secondRoot };
        } else if (discriminant == 0) {
            double singleRoot = -b / (2 * a);
            return new double[] { singleRoot };
        } else {
            return new double[] {}; // No real roots
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter coefficient a: ");
        double a = input.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = input.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = input.nextDouble();

        double[] roots = computeRoots(a, b, c);

        if (roots.length == 2) {
            System.out.println("Two distinct real roots: " + roots[0] + " and " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("One real root: " + roots[0]);
        } else {
            System.out.println("No real roots exist for the given equation.");
        }
    }
}
