import java.io.*;

public class FilterCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            int marks = Integer.parseInt(d[3]);
            if (marks > 80) {
                System.out.println(d[1] + " scored " + marks);
            }
        }
        br.close();
    }
}
