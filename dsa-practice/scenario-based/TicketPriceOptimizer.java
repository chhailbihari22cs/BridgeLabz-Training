import java.util.Arrays;

public class TicketPriceOptimizer {

    // Quick Sort Implementation
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort the left and right subarrays
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition Method
    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i + 1] and pivot (prices[high])
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return the pivot index
    }

    // Method to get the top N cheapest tickets
    public static double[] getTopCheapest(double[] prices, int n) {
        quickSort(prices, 0, prices.length - 1); // Sort the array
        return Arrays.copyOfRange(prices, 0, Math.min(n, prices.length)); // Return the first N elements
    }

    // Method to get the top N most expensive tickets
    public static double[] getTopMostExpensive(double[] prices, int n) {
        quickSort(prices, 0, prices.length - 1); // Sort the array
        return Arrays.copyOfRange(prices, Math.max(0, prices.length - n), prices.length); // Return the last N elements
    }

    public static void main(String[] args) {
        // Example ticket prices
        double[] ticketPrices = {1500.0, 1200.0, 2000.0, 1800.0, 1000.0, 2500.0, 3000.0, 800.0, 2200.0, 1700.0};

        // Get the top 5 cheapest tickets
        double[] cheapestTickets = getTopCheapest(ticketPrices.clone(), 5);
        System.out.println("Top 5 Cheapest Tickets: " + Arrays.toString(cheapestTickets));

        // Get the top 5 most expensive tickets
        double[] mostExpensiveTickets = getTopMostExpensive(ticketPrices.clone(), 5);
        System.out.println("Top 5 Most Expensive Tickets: " + Arrays.toString(mostExpensiveTickets));
    }
}