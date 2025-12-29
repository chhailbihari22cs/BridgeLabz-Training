import java.util.Scanner;

class TemperatureConvert {

    static double cToF(double c) {
        return (c * 9 / 5) + 32;
    }

    static double fToC(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        double temp = sc.nextDouble();

        if (choice == 1)
            System.out.println(cToF(temp));
        else
            System.out.println(fToC(temp));

        sc.close();
    }
}
