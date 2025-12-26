import java.util.Scanner;

public class SICalculator {
    public static double calculateSimpleInterest(double P, double R, double T) {
        return (P * R * T) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        double P = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double R = sc.nextDouble();

        System.out.print("Enter Time (in years): ");
        double T = sc.nextDouble();

        double SI = calculateSimpleInterest(P, R, T);
        System.out.println("Simple Interest is " + SI +
                " for Principal " + P +
                ", Rate of Interest " + R +
                " and Time " + T);
    }
}
