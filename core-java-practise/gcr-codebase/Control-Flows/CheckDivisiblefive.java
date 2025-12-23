import java.util.Scanner;

public class CheckDivisiblefive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int value = input.nextInt();

        boolean divisible = (value % 5 == 0);
        System.out.println("Is " + value + " divisible by 5? " + divisible);
    }
}
