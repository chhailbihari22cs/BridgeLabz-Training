
import java.util.*;

// Class ka naam: LibraryManager
public class LibraryManager {
    
    // Genre aur uski Books ki list
    HashMap<String, LinkedList<String>> catalog = new HashMap<>();

    // 1. Book add karne ka function
    public void addBook(String genre, String bookName) {
        // Agar genre pehle se nahi hai, toh nayi list banao
        if (!catalog.containsKey(genre)) {
            catalog.put(genre, new LinkedList<>());
        }
        // List mein book daal do
        catalog.get(genre).add(bookName);
        System.out.println(bookName + " added in " + genre);
    }

    // 2. Book remove karne ka function
    public void removeBook(String genre, String bookName) {
        if (catalog.containsKey(genre)) {
            catalog.get(genre).remove(bookName);
            System.out.println(bookName + " removed from " + genre);
        }
    }

    // 3. Poori library dekhne ke liye
    public void display() {
        System.out.println("\n--- Current Library ---");
        for (String genre : catalog.keySet()) {
            System.out.println(genre + " Books: " + catalog.get(genre));
        }
    }

    public static void main(String[] args) {
        LibraryManager lib = new LibraryManager();

        // Books add karna
        lib.addBook("Horror", "IT");
        lib.addBook("Horror", "Dracula");
        lib.addBook("Study", "Java Guide");

        lib.display();

        // Book remove karna
        lib.removeBook("Horror", "IT");

        lib.display();
    }
}