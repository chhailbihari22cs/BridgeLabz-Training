import java.util.Scanner;

public class PowerFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base number: ");
        int base = sc.nextInt();
        System.out.print("Enter power: ");
        int exponent = sc.nextInt();

        long result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        System.out.println(base + "^" + exponent + " = " + result);
    }
}
