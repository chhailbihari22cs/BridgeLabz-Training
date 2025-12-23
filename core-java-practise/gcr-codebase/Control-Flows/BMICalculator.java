import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight in kg: ");
        double weightKg = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double heightCm = sc.nextDouble();

        double heightM = heightCm / 100.0;
        if (heightM <= 0) {
            System.out.println("Invalid height.");
            return;
        }

        double bmi = weightKg / (heightM * heightM);
        System.out.printf("BMI = %.2f%n", bmi);

        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25.0) {
            category = "Normal weight";
        } else if (bmi < 30.0) {
            category = "Overweight";
        } else {
            category = "Obesity";
        }
        System.out.println("Weight status = " + category);
    }
}
