import java.util.*;

public class Table6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 6 and 9: ");
        int num = sc.nextInt();

        if (num < 6 || num > 9) {
            System.out.println("Number must be between 6 and 9.");
            return;
        }

        int[] result = new int[10];
        for (int i = 1; i <= 10; i++) {
            result[i - 1] = num * i;
        }

        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + result[i - 1]);
        }
    }
}
