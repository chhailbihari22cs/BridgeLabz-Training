import java.util.*;

public class SIOB {
    static void genEx(String s) {
        System.out.println(s.charAt(s.length())); // invalid index
    }

    static void handleEx(String s) {
        try {
            System.out.println(s.charAt(s.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled SIOB: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // genEx(s);
        handleEx(s);
    }
}
