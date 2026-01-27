import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class FileCopyExample {

    public static void main(String[] args) {

        File sourceFile = new File("source.txt");
        File destFile = new File("destination.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred during file handling.");
            e.printStackTrace();

        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing files.");
            }
        }
    }
}
