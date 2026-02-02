import java.io.*;
import java.util.*;

class Student {
    int id, age, marks;
    String name;

    Student(int i, String n, int a, int m) {
        id = i;
        name = n;
        age = a;
        marks = m;
    }
}

public class CSVtoObject {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        List<Student> list = new ArrayList<>();
        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            list.add(new Student(
                    Integer.parseInt(d[0]), d[1],
                    Integer.parseInt(d[2]), Integer.parseInt(d[3])));
        }
        br.close();

        for (Student s : list)
            System.out.println(s.name + " " + s.marks);
    }
}
