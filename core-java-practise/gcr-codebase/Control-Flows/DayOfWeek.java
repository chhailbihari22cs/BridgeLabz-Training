public class DayOfWeek {
    // Sakamoto's algorithm for Gregorian calendar
    public static int dayOfWeek(int year, int month, int day) {
        int[] t = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        if (month < 3)
            year -= 1;
        int w = (year + year / 4 - year / 100 + year / 400 + t[month - 1] + day) % 7;
        // Sakamoto returns 0 = Sunday, 1 = Monday, ...
        return w;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java DayOfWeek <month> <day> <year>");
            return;
        }
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        if (y < 1582) {
            System.out.println("Year must be >= 1582 for Gregorian calendar.");
            return;
        }
        if (m < 1 || m > 12) {
            System.out.println("Invalid month.");
            return;
        }
        if (d < 1 || d > 31) {
            System.out.println("Invalid day.");
            return;
        }

        int dow = dayOfWeek(y, m, d);
        System.out.println(dow);
    }
}
