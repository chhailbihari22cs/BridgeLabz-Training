import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String fileName = "large_log_file.txt"; // Teri file ka naam
        String searchWord = "error";
        int count = 0;

        // Pehle ek dummy file bana dete hain test karne ke liye (Optional)
        createDummyLog(fileName);

        // BufferedReader use karenge taaki RAM par load na pade
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Scanning for '" + searchWord + "'...");

            while ((line = br.readLine()) != null) {
                // Case-insensitive check (Error, ERROR, error sab chalega)
                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                    System.out.println("Match Found: " + line);
                    count++;
                }
            }
            System.out.println("\nTotal '" + searchWord + "' occurrences found: " + count);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Sirf testing ke liye choti file banane ka function
    private static void createDummyLog(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println("System started successfully.");
            pw.println("ERROR: Connection timeout at 10:45 AM");
            pw.println("User logged in.");
            pw.println("Critial error: Database not found.");
            pw.println("Log ended.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}