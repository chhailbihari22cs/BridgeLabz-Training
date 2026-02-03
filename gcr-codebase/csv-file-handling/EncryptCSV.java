import java.io.*;

public class EncryptCSV {
    static String encrypt(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("secure.csv");
        fw.write("ID,Salary\n");
        fw.write("1," + encrypt("50000") + "\n");
        fw.close();
    }
}
