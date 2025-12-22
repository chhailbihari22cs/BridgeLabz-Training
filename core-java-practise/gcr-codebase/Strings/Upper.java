import java.util.*;

public class Upper {
    static String toUpper(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                r += (char) (c - 32);
            else
                r += c;
        }
        return r;
    }

    static boolean cmpStr(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String r1 = toUpper(s);
        String r2 = s.toUpperCase();
        System.out.println("Compare: " + cmpStr(r1, r2));
    }
}
