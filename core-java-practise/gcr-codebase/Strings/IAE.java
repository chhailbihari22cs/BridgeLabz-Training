import java.util.*;

public class IAE {
    static void genEx(String s) {
        System.out.println(s.substring(5, 2)); // invalid
    }

    static void handleEx(String s) {
        try {
            System.out.println(s.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IAE: " + e);
        } catch (RuntimeException e) {
            System.out.println("Generic Runtime: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // genEx(s);
        handleEx(s);
    }
}
