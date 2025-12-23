import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amar's age and height: ");
        int ageAmar = sc.nextInt();
        int heightAmar = sc.nextInt();

        System.out.print("Enter Akbar's age and height: ");
        int ageAkbar = sc.nextInt();
        int heightAkbar = sc.nextInt();

        System.out.print("Enter Anthony's age and height: ");
        int ageAnthony = sc.nextInt();
        int heightAnthony = sc.nextInt();

        // Youngest
        if (ageAmar <= ageAkbar && ageAmar <= ageAnthony) {
            System.out.println("Amar is the youngest.");
        } else if (ageAkbar <= ageAmar && ageAkbar <= ageAnthony) {
            System.out.println("Akbar is the youngest.");
        } else {
            System.out.println("Anthony is the youngest.");
        }

        // Tallest
        if (heightAmar >= heightAkbar && heightAmar >= heightAnthony) {
            System.out.println("Amar is the tallest.");
        } else if (heightAkbar >= heightAmar && heightAkbar >= heightAnthony) {
            System.out.println("Akbar is the tallest.");
        } else {
            System.out.println("Anthony is the tallest.");
        }
    }
}
