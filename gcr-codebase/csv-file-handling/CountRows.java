import java.io.*;

public class CountRows {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        int count = 0;
        br.readLine(); // header

        while (br.readLine() != null) {
            count++;
        }
        br.close();
        System.out.println("Total Records: " + count);

    }
}
