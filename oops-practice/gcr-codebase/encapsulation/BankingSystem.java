import java.util.ArrayList;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Abstract method
    public abstract double calculateInterest();
}
interface Loanable {
    void applyForLoan(double amount);
    double calculateLoanEligibility();
}
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for Savings Account: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5;
    }
}
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for Current Account: " + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 10;
    }
}
public class BankingSystem {

    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA101", "Vishal", 50000));
        accounts.add(new CurrentAccount("CA202", "Karan", 100000));

        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                System.out.println("Loan Eligibility: " +
                        ((Loanable) acc).calculateLoanEligibility());
            }

            System.out.println("------------------------");
        }
    }
}

