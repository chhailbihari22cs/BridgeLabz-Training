import java.io.*;

public class LargeCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("big.csv"));
        int count = 0;
        String line;

        while ((line = br.readLine()) != null) {
            count++;
            if (count % 100 == 0)
                System.out.println("Processed: " + count);
        }
        br.close();
    }
}
