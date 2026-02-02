import java.io.*;
import java.util.*;

public class DuplicateCSV {
    public static void main(String[] args) throws Exception {
        Set<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String id = line.split(",")[0];
            if (!set.add(id))
                System.out.println("Duplicate: " + line);
        }
        br.close();
    }
}
