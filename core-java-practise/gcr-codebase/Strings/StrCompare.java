import java.util.*;

public class StrCompare {
    static boolean cmpStr(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(), s2 = sc.next();
        boolean r1 = cmpStr(s1, s2);
        boolean r2 = s1.equals(s2);
        System.out.println("User method: " + r1);
        System.out.println("Built-in equals: " + r2);
    }
}
