import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();

        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        br1.readLine();
        String l;
        while ((l = br1.readLine()) != null) {
            String[] d = l.split(",");
            map.put(d[0], l);
        }
        br1.close();

        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        FileWriter fw = new FileWriter("merged.csv");
        fw.write("ID,Name,Age,Marks,Grade\n");
        br2.readLine();

        while ((l = br2.readLine()) != null) {
            String[] d = l.split(",");
            fw.write(map.get(d[0]) + "," + d[1] + "," + d[2] + "\n");
        }
        br2.close();
        fw.close();
    }
}
