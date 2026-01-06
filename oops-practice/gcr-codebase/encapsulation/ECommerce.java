import java.util.ArrayList;
abstract class Product {
    private int productId;
    private String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {

    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10;
    }

    @Override
    public double calculateTax() {
        return price * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "GST 18%";
    }
}

class Clothing extends Product implements Taxable {

    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.20;
    }

    @Override
    public double calculateTax() {
        return price * 0.12;
    }

    @Override
    public String getTaxDetails() {
        return "GST 12%";
    }
}

class Groceries extends Product {

    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 0.05;
    }
}
public class ECommerce {

    public static void printFinalPrice(ArrayList<Product> products) {
        for (Product p : products) {
            double tax = 0;

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
            }

            double finalPrice = p.getPrice() + tax - p.calculateDiscount();
            System.out.println(p.getName() + " Final Price: " + finalPrice);
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "Jacket", 3000));
        products.add(new Groceries(103, "Rice", 1200));

        printFinalPrice(products);
    }
}

