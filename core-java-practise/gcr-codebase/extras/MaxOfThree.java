import java.util.Scanner;

class MaxOfThree {

    static int findMax(int a, int b, int c) {
        int max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int result = findMax(a, b, c);
        System.out.println("Maximum: " + result);

        sc.close();
    }
}
