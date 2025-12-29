import java.util.Scanner;

class Calculator {

    static int add(int a, int b) {
        return a + b;
    }

    static int sub(int a, int b) {
        return a - b;
    }

    static int mul(int a, int b) {
        return a * b;
    }

    static int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int choice = sc.nextInt();

        if (choice == 1)
            System.out.println(add(a, b));
        else if (choice == 2)
            System.out.println(sub(a, b));
        else if (choice == 3)
            System.out.println(mul(a, b));
        else
            System.out.println(div(a, b));

        sc.close();
    }
}
