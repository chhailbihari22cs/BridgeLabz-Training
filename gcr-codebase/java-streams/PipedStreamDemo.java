import java.io.*;

public class PipedStreamDemo {
    public static void main(String[] args) throws IOException {
        // 1. Pipe ke dono ends create karo
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output); // Dono connect ho gaye

        // 2. Thread - 1: Data Likhne Wala (Writer Thread)
        Thread writerThread = new Thread(() -> {
            try {
                String message = "Hello from the Writer Thread! Piped Streams are working.";
                System.out.println("Writer: Sending data...");
                output.write(message.getBytes());
                output.close(); // Likhne ke baad close karna zaroori hai
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 3. Thread - 2: Data Read Karne Wala (Reader Thread)
        Thread readerThread = new Thread(() -> {
            try {
                int data;
                System.out.print("Reader: Received data -> ");
                while ((data = input.read()) != -1) {
                    System.out.print((char) data);
                }
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Threads start karo
        writerThread.start();
        readerThread.start();
    }
}