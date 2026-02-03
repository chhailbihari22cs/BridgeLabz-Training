import java.io.*;

public class WriteCSV {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("employees.csv");

        fw.write("ID,Name,Department,Salary\n");
        fw.write("1,Amit,IT,50000\n");
        fw.write("2,Rahul,HR,45000\n");
        fw.write("3,Neha,IT,60000\n");
        fw.write("4,Priya,Sales,40000\n");
        fw.write("5,Ankit,IT,55000\n");

        fw.close();
    }
}
