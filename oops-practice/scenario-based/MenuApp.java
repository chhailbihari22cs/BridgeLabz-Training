import java.util.*;

public class MenuApp {

    public static void main(String[] args) {
        String[] menuItems = { "Veg Sandwich", "Cheese Burger", "French Fries", "Pasta", "Pizza", "Noodles", "Coffee",
                "Tea", "Juice", "Ice Cream" };

        displayItems(menuItems);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item index to order: ");
        int index = sc.nextInt();

        String selectedItem = getItemByIndex(menuItems, index);

        if (selectedItem != null) {
            System.out.println("You ordered: " + selectedItem);
        } else {
            System.out.println("Invalid item index!");
        }

    }

    public static void displayItems(String menu[]) {
        System.out.println("Cafeteria Menu");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + " : " + menu[i]);
        }
    }

    public static String getItemByIndex(String items[], int index) {
        if (index >= 0 && index < items.length) {
            return items[index];
        }
        return null;
    }

}