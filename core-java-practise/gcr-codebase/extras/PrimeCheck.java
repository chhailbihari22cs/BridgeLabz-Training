import java.util.Scanner;

class PrimeCheck {

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (isPrime(num))
            System.out.println("Prime number");
        else
            System.out.println("Not a prime number");

        sc.close();
    }
}
