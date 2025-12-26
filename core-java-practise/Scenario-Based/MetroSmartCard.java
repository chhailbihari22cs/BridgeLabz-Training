
import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("<---- DELHI METRO SMART CARD ---->");
        System.out.print("Enter initial smart card balance: ₹");
        double balance = sc.nextDouble();
        
        System.out.println("\nFare Structure:");
        System.out.println("0-5 km: ₹10");
        System.out.println("6-10 km: ₹20");
        System.out.println("11-20 km: ₹30");
        System.out.println("Above 20 km: ₹50\n");
        
        while (balance > 0) {
            System.out.print("Enter distance traveled in km (or 0 to quit): ");
            double distance = sc.nextDouble();
            
            // Exit condition
            if (distance == 0) {
                System.out.println("Thank you for using Delhi Metro!");
                break;
            }
            
            // Calculate fare using ternary operator
            double fare = (distance <= 5) ? 10 :
                         (distance <= 10) ? 20 :
                         (distance <= 20) ? 30 : 50;
            
            System.out.println("Fare for " + distance + " km: ₹" + fare);
            
            // Check if sufficient balance
            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted! Remaining balance: ₹" + balance + "\n");
            } else {
                System.out.println("Insufficient balance! Current balance: ₹" + balance);
                System.out.println("Please recharge your card.\n");
                break;
            }
        }
        
        if (balance <= 0 && balance != 0) {
            System.out.println("Your smart card balance is exhausted!");
        }
        
        System.out.println("Final balance: ₹" + balance);

    }
}