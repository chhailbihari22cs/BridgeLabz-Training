package LibraryBookStatistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book1", "Fiction", 300),
                new Book("Book2", "Fiction", 450),
                new Book("Book3", "Science", 500),
                new Book("Book4", "Science", 350),
                new Book("Book5", "History", 400));

        Map<String, IntSummaryStatistics> statsByGenre = books.stream().collect(Collectors.groupingBy(b -> b.genre,
                Collectors.summarizingInt(b -> b.pages)));

        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
            System.out.println();
        });

    }

}