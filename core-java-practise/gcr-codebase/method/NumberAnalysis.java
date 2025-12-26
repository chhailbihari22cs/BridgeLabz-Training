import java.util.Scanner;

public class NumberAnalysis {
    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int a, int b) {
        if (a > b)
            return 1;
        else if (a == b)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // Input numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        // Check each number
        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.print(num + " is Positive and ");
                System.out.println(isEven(num) ? "Even" : "Odd");
            } else {
                System.out.println(num + " is Negative");
            }
        }

        // Compare first and last
        int result = compare(numbers[0], numbers[numbers.length - 1]);
        if (result == 0) {
            System.out.println("First and last are equal.");
        } else if (result == 1) {
            System.out.println("First is greater than last.");
        } else {
            System.out.println("First is less than last.");
        }
    }
}
