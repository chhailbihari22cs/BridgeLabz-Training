import java.util.Scanner;

public class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read length and width of the rectangle
        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();

        // Calculate perimeter
        double perimeter = 2 * (length + width);

        // Display the result
        System.out.printf("The perimeter of the rectangle is: %.2f%n", perimeter);

        scanner.close();
    }
}