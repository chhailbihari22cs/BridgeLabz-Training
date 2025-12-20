import java.util.Scanner;

public class FirstIsSmallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int first = input.nextInt();
        int second = input.nextInt();
        int third = input.nextInt();

        boolean isSmallest = first <= second && first <= third;
        System.out.println("Is the first number the smallest? " + isSmallest);
    }
}
