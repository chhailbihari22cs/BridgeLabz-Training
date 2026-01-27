import java.io.*;
import java.util.Arrays;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputPath = "input.jpg";  // Source image ka naam
        String outputPath = "output.jpg"; // Jo nayi image banegi

        try {
            // 1. Image file ko Read karna (FileInputStream)
            FileInputStream fis = new FileInputStream(inputPath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Image data ko byte array stream mein likhna
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            // Data ko Byte Array mein convert karna
            byte[] imageBytes = baos.toByteArray();
            System.out.println("Image converted to Byte Array. Size: " + imageBytes.length + " bytes");

            // 2. Byte Array se wapas Image banana (ByteArrayInputStream)
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputPath);

            byte[] outputBuffer = new byte[1024];
            int n;
            while ((n = bais.read(outputBuffer)) != -1) {
                fos.write(outputBuffer, 0, n);
            }

            System.out.println("Success! New image saved as: " + outputPath);

            // 3. Verification (Check if files are identical)
            File file1 = new File(inputPath);
            File file2 = new File(outputPath);
            if (file1.length() == file2.length()) {
                System.out.println("Verification Successful: Both files are identical in size.");
            }

            // Streams close karna
            fis.close();
            baos.close();
            fos.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.out.println("Make sure 'input.jpg' exists in the folder.");
        }
    }
}

