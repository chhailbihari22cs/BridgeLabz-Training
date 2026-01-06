import java.util.*;

public class ParagraphFormatter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Paragraph");
        String input = sc.nextLine();
        int f = 1;
        if (input.length() == 0) {
            System.out.println("Enter Valid input String!!");
            f = 0;
        }
        input = input.trim();
        input = input.replaceAll("\\s+", " ");
        input = input.replaceAll("([.!?])\\s*", "$1 ");

        StringBuilder ans = new StringBuilder(input);
        ans.setCharAt(0, Character.toUpperCase(ans.charAt(0)));
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '.' || ans.charAt(i) == '?' || ans.charAt(i) == '!') {
                if (i + 2 < ans.length()) {
                    ans.setCharAt(i + 2, Character.toUpperCase(ans.charAt(i + 2)));
                }
            }
        }
        if (f == 1)
            System.out.println("Formatted String is: " + ans);
    }

}