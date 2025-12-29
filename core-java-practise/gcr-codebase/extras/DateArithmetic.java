import java.time.LocalDate;
import java.util.Scanner;

class DateArithmetic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter date (yyyy-mm-dd):");
        LocalDate date = LocalDate.parse(sc.next());

        LocalDate newDate = date.plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);

        System.out.println("Final date: " + newDate);
        sc.close();
    }
}
