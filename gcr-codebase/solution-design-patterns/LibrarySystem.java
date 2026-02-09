public class LibrarySystem {

    public static void main(String[] args) {

        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User u1 = UserFactory.createUser("STUDENT", "Aman");
        User u2 = UserFactory.createUser("FACULTY", "Dr. Sharma");

        catalog.addObserver(u1);
        catalog.addObserver(u2);

        Book book = new Book.Builder("Data Structures")
                .addAuthor("Cormen")
                .edition(3)
                .genre("Computer Science")
                .publisher("MIT Press")
                .build();

        catalog.addBook(book);
    }
}
