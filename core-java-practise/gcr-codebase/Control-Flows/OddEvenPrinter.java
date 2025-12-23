import java.util.Scanner;

public class OddEvenPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int limit = sc.nextInt();

        if (limit <= 0) {
            System.out.println("Invalid input. Please enter a natural number.");
        } else {
            for (int i = 1; i <= limit; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is Even");
                } else {
                    System.out.println(i + " is Odd");
                }
            }
        }
    }
}
