import java.util.Random;

public class RandomFourDigitStats {

    public static int[] createRandomNumbers(int count) {
        int[] values = new int[count];
        Random generator = new Random();

        for (int i = 0; i < count; i++) {
            values[i] = 1000 + generator.nextInt(9000);
        }
        return values;
    }

    public static double[] analyzeNumbers(int[] values) {
        int smallest = values[0];
        int largest = values[0];
        int total = 0;

        for (int val : values) {
            total += val;
            if (val < smallest)
                smallest = val;
            if (val > largest)
                largest = val;
        }

        double average = (double) total / values.length;
        return new double[] { average, smallest, largest };
    }

    public static void main(String[] args) {
        int[] randomValues = createRandomNumbers(5);

        System.out.print("Generated numbers: ");
        for (int val : randomValues) {
            System.out.print(val + " ");
        }
        System.out.println();

        double[] results = analyzeNumbers(randomValues);
        System.out.printf("Average: %.2f\n", results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }
}
