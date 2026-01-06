import java.util.ArrayList;

abstract class FoodItem {
    private String itemName;
    protected double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation
    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    protected double getBaseAmount() {
        return price * quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println(itemName + " | Qty: " + quantity + " | Total: " + calculateTotalPrice());
    }
}
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        return getBaseAmount() - applyDiscount();
    }

    @Override
    public double applyDiscount() {
        return getBaseAmount() * 0.10;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount 10%";
    }
}
class NonVegItem extends FoodItem implements Discountable {

    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override
    public double calculateTotalPrice() {
        double extraCharge = getBaseAmount() * 0.15;
        return getBaseAmount() + extraCharge - applyDiscount();
    }

    @Override
    public double applyDiscount() {
        return getBaseAmount() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount 5%";
    }
}
public class OnlineFoodDeliverySystem {

    public static void processOrder(ArrayList<FoodItem> items) {
        for (FoodItem item : items) {
            item.getItemDetails();
        }
    }

    public static void main(String[] args) {

        ArrayList<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));

        processOrder(order);
    }
}
