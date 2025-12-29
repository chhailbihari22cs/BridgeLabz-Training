import java.util.Scanner;

class FestiveLuckyDraw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of visitors:");
        int visitors = sc.nextInt();

        for (int i = 1; i <= visitors; i++) {

            System.out.println("Enter number for visitor " + i + ":");
            int number = sc.nextInt();

            if (number <= 0) {
                System.out.println("Invalid number, try next visitor");
                continue;
            }

            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("Congratulations! You won a gift 🎁");
            } else {
                System.out.println("Sorry, better luck next time");
            }
        }

        sc.close();
    }
}
