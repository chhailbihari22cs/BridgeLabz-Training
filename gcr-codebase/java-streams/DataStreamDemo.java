import java.io.*;

public class DataStreamDemo {
    public static void main(String[] args) {
        String fileName = "student_data.bin";

        // 1. DATA WRITE KARNA (DataOutputStream)
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Student Details
            int rollNo = 101;
            String name = "Aryan";
            double gpa = 8.5;

            dos.writeInt(rollNo);
            dos.writeUTF(name); // String ke liye writeUTF use hota hai
            dos.writeDouble(gpa);

            System.out.println("Data successfully written to binary file.");
        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }

        System.out.println("------------------------------------");

        // 2. DATA READ KARNA (DataInputStream)
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            // Dhyaan rakho: Jis order mein write kiya tha, usi order mein read karna hoga
            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Retrieved Student Details:");
            System.out.println("Roll No: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }
}
