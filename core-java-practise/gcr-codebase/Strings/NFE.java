import java.util.*;

public class NFE {
    static void genEx(String s) {
        int n = Integer.parseInt(s); // invalid if not number
        System.out.println(n);
    }

    static void handleEx(String s) {
        try {
            int n = Integer.parseInt(s);
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println("Handled NFE: " + e);
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
