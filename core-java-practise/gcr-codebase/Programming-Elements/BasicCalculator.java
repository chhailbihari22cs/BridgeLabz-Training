import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();

        double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;
        double quotient = (number2 != 0) ? number1 / number2 : Double.NaN; // handle division by zero

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers "
                + number1 + " and " + number2 + " is: ");
        System.out.println("Addition = " + sum);
        System.out.println("Subtraction = " + difference);
        System.out.println("Multiplication = " + product);
        if (number2 != 0) {
            System.out.println("Division = " + quotient);
        } else {
            System.out.println("Division = Undefined (cannot divide by zero)");
        }
    }
}
