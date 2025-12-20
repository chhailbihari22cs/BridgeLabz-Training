import java.util.Scanner;

public class SumNaturalFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n >= 0) {
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumLoop += i;
            }
            System.out.println("Sum by formula = " + sumFormula);
            System.out.println("Sum by for loop = " + sumLoop);
            System.out.println("Both results are equal? " + (sumFormula == sumLoop));
        } else {
            System.out.println("Not a natural number");
        }
    }
}
