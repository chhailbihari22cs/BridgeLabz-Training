
import java.util.Scanner;
public class CoffeeShop{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int Cost = 0; //Variable to store the total cost
        int Decision = 1;  //Store if they want to buy more coffee or not
        while(Decision==1){
            System.out.print("""
                S.No.   Coffee Type                     Price(+GST)
                1       Espresso (single shot)           ₹160
                2       Double Espresso                  ₹200
                3       Americano (hot)                  ₹215
                4       Cappuccino                       ₹260
                5       Cafe Latte                       ₹235
                """);
            System.out.println("\nEnter your choice's S.No.");
            int Choice = input.nextInt();
            System.out.println("Please Enter the quantity");
            int Quantity = input.nextInt();
            switch(Choice){ //Used cases to store the price of the Coffies
                case 1:
                    Cost+=160;
                    break;
                case 2:
                    Cost+=200;
                    break;
                case 3:
                    Cost+=215;
                    break;
                case 4:
                    Cost+=260;
                    break;
                case 5:
                    Cost+=235;
                    break;
                default:
                    System.out.print("Please enter a valid key!!");
            }
            int TotalBill = (Quantity*Cost)+((Quantity*Cost)/20); //Calculating the Total Bill

            System.out.println("If you want to continue buying more coffee please choose 1 otherwise choose 0");
            Decision = input.nextInt(); // Checks if they want to buy more or not

            if(Decision==0) {
                System.out.println("<------------------------------------------------------------------------------------->");
                System.out.println("Rs "+Cost+" is the Coffee Price and Rs "+(Cost/20)+" GST and total bill is of Rs "+TotalBill);
                break;
            }
        }
    }
}