import java.io.*;

public class UpdateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        FileWriter fw = new FileWriter("updated_employees.csv");

        fw.write(br.readLine() + "\n");
        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (d[2].equals("IT")) {
                double sal = Double.parseDouble(d[3]);
                d[3] = String.valueOf(sal * 1.10);
            }
            fw.write(String.join(",", d) + "\n");
        }
        br.close();
        fw.close();
    }
}
