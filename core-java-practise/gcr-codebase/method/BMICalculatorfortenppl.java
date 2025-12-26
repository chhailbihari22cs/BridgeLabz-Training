import java.util.Scanner;

public class BMICalculatorfortenppl {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            data[i][2] = bmi;
        }
    }

    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] teamData = new double[10][3]; // [weight, height, BMI]

        for (int i = 0; i < teamData.length; i++) {
            System.out.println("Enter details for member " + (i + 1));
            System.out.print("Weight (kg): ");
            teamData[i][0] = sc.nextDouble();
            System.out.print("Height (cm): ");
            teamData[i][1] = sc.nextDouble();
        }

        calculateBMI(teamData);

        String[] bmiStatus = determineBMIStatus(teamData);

        System.out.println("\nBMI Report:");
        System.out.println("Member\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < teamData.length; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n",
                    (i + 1), teamData[i][0], teamData[i][1], teamData[i][2], bmiStatus[i]);
        }
    }
}
