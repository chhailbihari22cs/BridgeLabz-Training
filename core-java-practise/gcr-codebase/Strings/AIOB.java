import java.util.*;

public class AIOB {
    static void genEx(String[] arr) {
        System.out.println(arr[arr.length]); // invalid index
    }

    static void handleEx(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled AIOB: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.next();
        // genEx(arr);
        handleEx(arr);
    }
}
