import java.io.*;
import java.util.*;

public class WordCountExpert {
    public static void main(String[] args) {
        String fileName = "input.txt";
        Map<String, Integer> wordMap = new HashMap<>();

        // 1. File Read karna aur Word Count karna
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Symbols ko hata kar sirf words nikalna (Regex use kiya hai)
                String[] words = line.toLowerCase().split("\\W+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // 2. HashMap ko sort karna frequency ke basis par
            List<Map.Entry<String, Integer>> list = new ArrayList<>(wordMap.entrySet());
            list.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Descending order

            // 3. Top 5 Words display karna
            System.out.println("--- Top 5 Most Frequent Words ---");
            int count = 0;
            for (Map.Entry<String, Integer> entry : list) {
                if (count >= 5) break;
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
                count++;
            }

        } catch (IOException e) {
            System.err.println("Error: File not found. Please create 'input.txt'.");
        }
    }
}