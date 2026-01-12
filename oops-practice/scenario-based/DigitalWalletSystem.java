import java.util.*;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Interface for Transfer Service
interface TransferService {
    void transferFunds(User from, User to, double amount) throws InsufficientBalanceException;
}

// Wallet Class
class Wallet {
    private double balance;

    public Wallet() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void addMoney(double amount) {
        balance += amount;
        System.out.println("Rs." + amount + " added to wallet. Current balance: Rs." + balance);
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance in wallet. Current balance: Rs." + balance);
        }
        balance -= amount;
        System.out.println("Rs." + amount + " withdrawn from wallet. Remaining balance: Rs." + balance);
    }
}

// User Class
class User {
    private String userId;
    private String name;
    private Wallet wallet;
    private List<String> transactionHistory;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet();
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public void viewTransactionHistory() {
        System.out.println("Transaction History for " + name + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Implementation of Transfer Service
class WalletTransferService implements TransferService {
    @Override
    public void transferFunds(User from, User to, double amount) throws InsufficientBalanceException {
        from.getWallet().withdrawMoney(amount);
        to.getWallet().addMoney(amount);

        String transaction = "Transferred Rs." + amount + " to " + to.getName();
        from.addTransaction(transaction);

        transaction = "Received Rs." + amount + " from " + from.getName();
        to.addTransaction(transaction);

        System.out.println(
                "Transfer of Rs." + amount + " from " + from.getName() + " to " + to.getName() + " completed.");
    }
}

// Main Class
public class DigitalWalletSystem {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("U001", "Alice");
        User user2 = new User("U002", "Bob");

        // Add money to wallets
        user1.getWallet().addMoney(5000);
        user2.getWallet().addMoney(2000);

        // Transfer service
        TransferService transferService = new WalletTransferService();

        try {
            // Transfer funds
            transferService.transferFunds(user1, user2, 1500);

            // View transaction history
            user1.viewTransactionHistory();
            user2.viewTransactionHistory();

            // Attempt to transfer more than available balance
            transferService.transferFunds(user2, user1, 3000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}