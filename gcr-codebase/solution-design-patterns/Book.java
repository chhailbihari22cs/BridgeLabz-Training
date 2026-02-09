import java.util.*;

public class Book {

    private String title;
    private List<String> authors;
    private int edition;
    private String genre;
    private String publisher;

    private Book(Builder builder) {
        this.title = builder.title;
        this.authors = builder.authors;
        this.edition = builder.edition;
        this.genre = builder.genre;
        this.publisher = builder.publisher;
    }

    public String getTitle() {
        return title;
    }

    public static class Builder {

        private String title;
        private List<String> authors = new ArrayList<>();
        private int edition;
        private String genre;
        private String publisher;

        public Builder(String title) {
            this.title = title;
        }

        public Builder addAuthor(String author) {
            authors.add(author);
            return this;
        }

        public Builder edition(int edition) {
            this.edition = edition;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
