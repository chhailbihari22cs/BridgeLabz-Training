import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();

        int value = Math.abs(n);
        if (value == 0) {
            System.out.println("Number of digits = 1");
            return;
        }

        int count = 0;
        while (value != 0) {
            value /= 10;
            count++;
        }
        System.out.println("Number of digits = " + count);
    }
}
