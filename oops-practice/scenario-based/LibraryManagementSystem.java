import java.util.*;

public class LibraryManagementSystem {

    static String[] titles = {
            "Java Programming",
            "Data Structures",
            "Python Basics",
            "Web Development",
            "Operating Systems"
    };

    static String[] authors = {
            "James Gosling",
            "Mark Allen",
            "Guido van Rossum",
            "Tim Berners-Lee",
            "Abraham Silberschatz"
    };

    static boolean[] isAvailable = { true, true, true, true, true };

    static List<Integer> bookList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < titles.length; i++) {
            bookList.add(i);
        }

        System.out.println("All Book Details:");
        displayBooks();

        System.out.print("\nEnter keyword to search book: ");
        String keyword = sc.nextLine();
        searchBook(keyword);

        System.out.print("\nEnter title of book to checkout: ");
        String title = sc.nextLine();

        try {
            withdrawBook(title);
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    public static void displayBooks() {
        for (int i = 0; i < titles.length; i++) {
            System.out.println(
                    "Title: " + titles[i] +
                            " | Author: " + authors[i] +
                            " | Status: " + (isAvailable[i] ? "Available" : "Checked Out"));
        }
    }

    public static void withdrawBook(String title) throws BookNotAvailableException {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equalsIgnoreCase(title)) {

                if (isAvailable[i]) {
                    isAvailable[i] = false;
                    System.out.println("Book checked out successfully.");
                } else {
                    throw new BookNotAvailableException("Book is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void searchBook(String keyword) {
        boolean found = false;

        for (int i : bookList) {
            if (titles[i].toLowerCase().contains(keyword.toLowerCase())) {
                found = true;
                System.out.println(
                        "Title: " + titles[i] +
                                " | Author: " + authors[i] +
                                " | Status: " + (isAvailable[i] ? "Available" : "Checked Out"));
            }
        }

        if (!found) {
            System.out.println("No books found with keyword: " + keyword);
        }
    }
}

class BookNotAvailableException extends Exception {
    BookNotAvailableException(String message) {
        super(message);
    }
}
