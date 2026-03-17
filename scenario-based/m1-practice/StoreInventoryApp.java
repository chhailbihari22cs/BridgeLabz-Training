

import java.util.*;

abstract class Item {

    String itemName;
    double unitPrice;
    int count;

    Item(String itemName, double unitPrice, int count) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.count = count;
    }

    abstract void show();

    double totalWorth() {
        return unitPrice * count;
    }
}

class ElectronicItem extends Item {

    int warrantyMonths;

    ElectronicItem(String itemName, double unitPrice, int count, int warrantyMonths) {
        super(itemName, unitPrice, count);
        this.warrantyMonths = warrantyMonths;
    }

    void show() {
        System.out.println(itemName + " | Price: " + unitPrice +
                " | Qty: " + count + " | Warranty: " + warrantyMonths + " months");
    }
}

class ClothingItem extends Item {

    String sizeCode;

    ClothingItem(String itemName, double unitPrice, int count, String sizeCode) {
        super(itemName, unitPrice, count);
        this.sizeCode = sizeCode;
    }

    void show() {
        System.out.println(itemName + " | Price: " + unitPrice +
                " | Qty: " + count + " | Size: " + sizeCode);
    }
}

public class StoreInventoryApp {

    static List<Item> stock = new LinkedList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int entries = Integer.parseInt(in.nextLine().trim());

        while (entries-- > 0) {

            String data = in.nextLine().trim();
            if (data.length() == 0) {
                entries++;
                continue;
            }

            String[] tokens = data.split("\\s*,\\s*");
            String category = tokens[0];

            if ("Electronics".equalsIgnoreCase(category)) {

                Item obj = new ElectronicItem(
                        tokens[1],
                        Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3]),
                        Integer.parseInt(tokens[4])
                );

                stock.add(obj);
                System.out.println("Product added to inventory: " + tokens[1]);
            }

            else if ("Clothing".equalsIgnoreCase(category)) {

                Item obj = new ClothingItem(
                        tokens[1],
                        Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3]),
                        tokens[4]
                );

                stock.add(obj);
                System.out.println("Product added to inventory: " + tokens[1]);
            }
        }

        System.out.println("Inventory:");
        double sum = 0;

        for (Item it : stock) {
            it.show();
            sum += it.totalWorth();
        }

        System.out.printf("Total value of the inventory: %.2f%n", sum);
    }
}