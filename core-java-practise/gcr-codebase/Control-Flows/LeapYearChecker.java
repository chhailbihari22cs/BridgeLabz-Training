import java.util.Scanner;

public class LeapYearChecker {

    // 1. Leap Year Program - Multiple If-Else Conditions
    public static void checkLeapYearUsingIfElse(int year) {
        if (year < 1582) {
            System.out.println("LeapYear program only works for years >= 1582");
        } else if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a Leap Year.");
                } else {
                    System.out.println(year + " is not a Leap Year.");
                }
            } else {
                System.out.println(year + " is a Leap Year.");
            }
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
    }
}