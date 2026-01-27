import java.io.*;
public class BufferedStreamCopy {
	
	static final int BUFFER_SIZE = 4096;
	
	public static void main(String[] args) {
		
		File source = new File("C:\\Users\\dimpl\\Desktop\\BridgeLabz-Training\\collection-practice\\gcr-codebase\\streams\\source.txt");

		try {
			long start = System.nanoTime();
	        copyUnbuffered(source, "unbuffered_copy.txt");
	        long end = System.nanoTime();
	        System.out.println("Unbuffered Time: " + (end - start) + " ns");
	        
	        start = System.nanoTime();
	        copyBuffered(source, "buffered_copy.txt");
	        end = System.nanoTime();
	        System.out.println("Buffered Time: " + (end - start) + " ns");
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void copyUnbuffered(File source, String dest) throws IOException {

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
	
	private static void copyBuffered(File source, String dest) throws IOException {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

}
