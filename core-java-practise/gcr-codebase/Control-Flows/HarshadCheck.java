import java.util.Scanner;

public class HarshadCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input.");
            return;
        }

        int temp = number;
        int sumDigits = 0;
        while (temp != 0) {
            sumDigits += temp % 10;
            temp /= 10;
        }

        if (sumDigits != 0 && number % sumDigits == 0) {
            System.out.println(number + " is a Harshad number.");
        } else {
            System.out.println(number + " is not a Harshad number.");
        }
    }
}
