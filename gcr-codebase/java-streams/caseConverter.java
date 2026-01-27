import java.io.*;
import java.nio.charset.StandardCharsets;

public class caseConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";  // Original file
        String outputFile = "output.txt"; // Choti ABC wali file

        // Pehle ek sample file create kar lete hain agar nahi hai toh
        createSampleFile(inputFile);

        // BufferedReader aur BufferedWriter ka use 'Try-with-resources' ke saath
        // StandardCharsets.UTF_8 handles encoding issues
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Poori line ko lowercase mein convert karna
                writer.write(line.toLowerCase());
                writer.newLine(); // Agli line ke liye
            }
            
            System.out.println("Success! Uppercase text converted to lowercase in: " + outputFile);

        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }

    // Help function to create input.txt for testing
    private static void createSampleFile(String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("HELLO WORLD! This is JAVA Programming.\nWE ARE USING FILTER STREAMS.");
        } catch (IOException e) {
            System.out.println("Could not create sample file.");
        }
    }
}