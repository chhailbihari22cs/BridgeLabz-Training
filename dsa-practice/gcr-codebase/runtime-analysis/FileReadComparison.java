import java.io.*;

public class FileReadComparison {

    public static void main(String[] args) {
        String filePath = "large_data.txt"; // Maan lo ye 500MB ki file hai

        // 1. Using FileReader
        long start = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            int data;
            while ((data = fr.read()) != -1) {
                // Sirf read kar rahe hain, print nahi (warna console hang ho jayega)
            }
        } catch (IOException e) {
            System.out.println("File create karlo pehle!");
        }
        long end = System.nanoTime();
        System.out.println("FileReader Time: " + (end - start) / 1000000.0 + " ms");

        // 2. Using InputStreamReader (Generally paired with FileInputStream)
        start = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            int data;
            while ((data = isr.read()) != -1) {
                // Reading bytes converted to characters
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (end - start) / 1000000.0 + " ms");
    }
}