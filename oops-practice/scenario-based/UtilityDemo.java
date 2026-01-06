
public class UtilityDemo {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        if (prime(5)) {
            System.out.println("Number is prime");
        } else {
            System.out.println("Number is not prime");
        }
        System.out.println(findGCD(25, 15));
        numberCheck(8);
        System.out.println(nthFibonacci(5));

    }

    public static int factorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    public static boolean prime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findGCD(int num1, int num2) {
        int gcd = 1;
        int len = Math.min(num1, num2);
        for (int i = 1; i <= len; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void numberCheck(int number) {
        if (number > 0) {
            System.out.println("Number is positive");
        } else if (number < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is equal to zero");
        }
    }

    public static int nthFibonacci(int number) {
        int a = 0;
        int b = 1;
        int ans = 0;
        for (int i = 0; i < number; i++) {
            ans = a;
            int c = a + b;
            a = b;
            b = c;
        }
        return ans;
    }

}
