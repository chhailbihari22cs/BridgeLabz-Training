import java.util.Scanner;
import java.util.Random;

class NumberGuessGame {

    static int generateGuess(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low + 1) + low;
    }

    static String getFeedback(Scanner sc) {
        return sc.next();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int low = 1, high = 100;
        String feedback = "";

        System.out.println("Think of a number between 1 and 100");

        while (!feedback.equals("correct")) {

            int guess = generateGuess(low, high);
            System.out.println("My guess: " + guess);
            System.out.println("Enter feedback (high/low/correct):");

            feedback = getFeedback(sc);

            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }

        System.out.println("Number guessed successfully!");
        sc.close();
    }
}
