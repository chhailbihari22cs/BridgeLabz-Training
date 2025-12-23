import java.util.Scanner;

public class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n >= 0) {
            int sumFormula = n * (n + 1) / 2;
            int sumLoop = 0;
            int i = 1;
            while (i <= n) {
                sumLoop += i;
                i++;
            }
            System.out.println("Sum by formula = " + sumFormula);
            System.out.println("Sum by while loop = " + sumLoop);
            System.out.println("Both results are equal? " + (sumFormula == sumLoop));
        } else {
            System.out.println("Not a natural number");
        }
    }
}
