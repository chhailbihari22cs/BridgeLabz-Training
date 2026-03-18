import java.util.Scanner;

public class AccessKeyCreator {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int cases = Integer.parseInt(reader.nextLine().trim());
        while (cases-- > 0) {

            String text = reader.nextLine();
            String key = buildKey(text);

            if (key.startsWith("Invalid"))
                System.out.println(key);
            else
                System.out.println("The generated key is - " + key);
        }
    }

    private static String buildKey(String text) {

        if (text == null || text.isBlank())
            return "Invalid Input (empty string)";

        if (text.length() < 6)
            return "Invalid Input (length < 6)";

        if (!text.matches("[A-Za-z]+"))
            return detectReason(text);

        String lower = text.toLowerCase();
        StringBuilder sb = new StringBuilder();

        lower.chars()
                .filter(ch -> ch % 2 != 0)
                .forEach(ch -> sb.append((char) ch));

        sb.reverse();

        for (int i = 0; i < sb.length(); i += 2) {
            sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
        }

        return sb.toString();
    }

    private static String detectReason(String s) {

        if (s.contains(" "))
            return "Invalid Input (contains space)";

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                return "Invalid Input (contains digits)";
            if (!Character.isLetter(c))
                return "Invalid Input (contains special character)";
        }

        return "Invalid Input";
    }
}