import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailAccessChecker {

    private static final Set<String> DEPARTMENTS =
            Set.of("sales", "marketing", "IT", "product");

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^([a-z]{3,})\\.([a-z]{3,})(\\d{4,})@([^.]+)\\.company\\.com$");

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int total = Integer.parseInt(input.nextLine().trim());

        while (total-- > 0) {
            String mail = input.nextLine().trim();
            System.out.println(checkAccess(mail) ? "Access Granted" : "Access Denied");
        }
    }

    private static boolean checkAccess(String mail) {

        if (mail.isBlank() || mail.indexOf(' ') >= 0)
            return false;

        Matcher matcher = EMAIL_PATTERN.matcher(mail);

        if (!matcher.matches())
            return false;

        String department = matcher.group(4);

        return DEPARTMENTS.stream()
                .anyMatch(d -> d.equals(department));
    }
}