import java.util.*;

public class StringReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder ans = new StringBuilder();
        ans.append(input);
        ans.reverse();
        String result = ans.toString();
        System.out.println("Reversed String is: " + result);
    }

}