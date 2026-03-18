import java.util.*;

public class ShipmentValidator {

    static final Set<String> VALID_MODES = Set.of(
            "AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT"
    );

    static final Set<String> VALID_STATUS = Set.of(
            "DELIVERED", "CANCELLED", "IN_TRANSIT"
    );

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String record = sc.nextLine();
            System.out.println(
                    isValid(record)
                            ? "COMPLIANT RECORD"
                            : "NON-COMPLIANT RECORD"
            );
        }
    }

    static boolean isValid(String record) {

        String[] p = record.split("\\|");
        if (p.length != 5) return false;

        return validateCode(p[0])
                && validateDate(p[1])
                && VALID_MODES.contains(p[2])
                && validateWeight(p[3])
                && VALID_STATUS.contains(p[4]);
    }

    static boolean validateCode(String code) {

        if (code.length() != 11 || !code.startsWith("SHIP-"))
            return false;

        String digits = code.substring(5);

        if (digits.charAt(0) == '0')
            return false;

        int repeat = 1;

        for (int i = 0; i < digits.length(); i++) {

            char c = digits.charAt(i);

            if (!Character.isDigit(c))
                return false;

            if (i > 0 && c == digits.charAt(i - 1)) {
                if (++repeat > 3) return false;
            } else {
                repeat = 1;
            }
        }
        return true;
    }

    
    static boolean validateDate(String date) {

        if (date.length() != 10
                || date.charAt(4) != '-'
                || date.charAt(7) != '-')
            return false;

        int year, month, day;

        try {
            year = Integer.parseInt(date.substring(0, 4));
            month = Integer.parseInt(date.substring(5, 7));
            day = Integer.parseInt(date.substring(8, 10));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }

        if (year < 2000 || year > 2099)
            return false;

        if (month < 1 || month > 12)
            return false;

        int maxDay = switch (month) {
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };

        return day >= 1 && day <= maxDay;
    }

    static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    // 🔹 Weight Validation
    static boolean validateWeight(String w) {

        int dot = 0;

        for (char c : w.toCharArray()) {
            if (c == '.') dot++;
            else if (!Character.isDigit(c)) return false;
        }

        if (dot > 1) return false;

        String[] p = w.split("\\.");
        String intPart = p[0];

        if (intPart.length() > 1 && intPart.startsWith("0"))
            return false;

        if (p.length == 2 && p[1].length() > 2)
            return false;

        double val;
        try {
            val = Double.parseDouble(w);
        } catch (Exception e) {
            return false;
        }

        return val > 0 && val <= 999999.99;
    }
}