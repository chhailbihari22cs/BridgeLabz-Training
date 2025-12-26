import java.util.Scanner;
public class FitnessTracker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter your Height(M): ");
        int Height = sc.nextInt();
        System.out.println("\nPlease Enter your Weight(Kg)");
        int Weight = sc.nextInt();
        double BMI = Weight/(Height*Height);
        if(BMI<18.5){
            System.out.print("You are Underweight");
        }
        else if(BMI>=18.5 && BMI<=24.9){
            System.out.print("You are Normal in BMI");
        }
        else{
            System.out.println("You are in Obese category");
        }

    }
}
