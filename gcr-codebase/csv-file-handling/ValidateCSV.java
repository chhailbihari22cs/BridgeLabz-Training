import java.io.*;

public class ValidateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        br.readLine();
        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (!d[2].matches("\\d{10}") ||
                    !d[1].matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                System.out.println("Invalid Row: " + line);
            }
        }
        br.close();
    }
}
