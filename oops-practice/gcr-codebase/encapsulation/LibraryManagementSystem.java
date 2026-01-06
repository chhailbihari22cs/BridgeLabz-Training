import java.util.ArrayList;

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    private String borrowerName; // secured data

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Encapsulation
    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    protected void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            setBorrowerName(borrowerName);
            isAvailable = false;
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}
class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            setBorrowerName(borrowerName);
            isAvailable = false;
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}
class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            setBorrowerName(borrowerName);
            isAvailable = false;
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}
public class LibraryManagementSystem {

    public static void main(String[] args) {

        ArrayList<LibraryItem> items = new ArrayList<>();

        items.add(new Book(1, "Java Programming", "James Gosling"));
        items.add(new Magazine(2, "Tech Monthly", "Editorial Team"));
        items.add(new DVD(3, "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                System.out.println("Available: " +
                        ((Reservable) item).checkAvailability());
            }
            System.out.println("----------------------");
        }
    }
}
