import java.util.*;

// Custom Exception for Payment Failure
class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

// Interface for Payment
interface Payment {
    void processPayment(double amount) throws PaymentFailedException;
}

// Card Payment Implementation
class CardPayment implements Payment {
    @Override
    public void processPayment(double amount) throws PaymentFailedException {
        System.out.println("Processing card payment of ₹" + amount);
        // Simulate payment success
        if (amount > 10000) {
            throw new PaymentFailedException("Card payment failed: Amount exceeds limit.");
        }
        System.out.println("Card payment successful!");
    }
}

// UPI Payment Implementation
class UpiPayment implements Payment {
    @Override
    public void processPayment(double amount) throws PaymentFailedException {
        System.out.println("Processing UPI payment of ₹" + amount);
        // Simulate payment success
        if (amount > 5000) {
            throw new PaymentFailedException("UPI payment failed: Amount exceeds limit.");
        }
        System.out.println("UPI payment successful!");
    }
}

// Wallet Payment Implementation
class WalletPayment implements Payment {
    @Override
    public void processPayment(double amount) throws PaymentFailedException {
        System.out.println("Processing wallet payment of ₹" + amount);
        // Simulate payment success
        if (amount > 3000) {
            throw new PaymentFailedException("Wallet payment failed: Insufficient balance.");
        }
        System.out.println("Wallet payment successful!");
    }
}

// Product Class
class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order Class
class Order {
    private String orderId;
    private Product product;
    private String status;

    public Order(String orderId, Product product) {
        this.orderId = orderId;
        this.product = product;
        this.status = "Placed";
    }

    public String getOrderId() {
        return orderId;
    }

    public Product getProduct() {
        return product;
    }

    public String getStatus() {
        return status;
    }

    public void cancelOrder() {
        if (status.equals("Placed")) {
            status = "Cancelled";
            System.out.println("Order " + orderId + " has been cancelled.");
        } else {
            System.out.println("Order " + orderId + " cannot be cancelled.");
        }
    }
}

// Customer Class
class Customer {
    private String customerId;
    private String name;
    private List<Order> orders;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Product product, Payment paymentMethod) {
        String orderId = "ORD" + (orders.size() + 1);
        Order order = new Order(orderId, product);
        try {
            paymentMethod.processPayment(product.getPrice());
            orders.add(order);
            System.out.println("Order " + orderId + " placed successfully for product: " + product.getName());
        } catch (PaymentFailedException e) {
            System.out.println("Order " + orderId + " failed: " + e.getMessage());
        }
    }

    public void cancelOrder(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                order.cancelOrder();
                return;
            }
        }
        System.out.println("Order " + orderId + " not found.");
    }

    public void viewOrders() {
        System.out.println("Orders for " + name + ":");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + ", Product: " + order.getProduct().getName()
                    + ", Status: " + order.getStatus());
        }
    }
}

// Main Class
public class ECommerceOrderManagementSystem {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product("P001", "Laptop", 45000);
        Product product2 = new Product("P002", "Headphones", 2000);

        // Create customer
        Customer customer = new Customer("C001", "Alice");

        // Place orders
        customer.placeOrder(product1, new CardPayment());
        customer.placeOrder(product2, new WalletPayment());

        // View orders
        customer.viewOrders();

        // Cancel an order
        customer.cancelOrder("ORD1");

        // View orders after cancellation
        customer.viewOrders();
    }
}