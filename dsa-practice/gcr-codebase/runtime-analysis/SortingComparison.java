import java.util.*;

public class SortingComparison {

    // 1. Bubble Sort: O(N^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 2. Quick Sort: O(N log N)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int n = 10000; // 10,000 elements
        int[] original = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++)
            original[i] = rand.nextInt(10000);

        // Test Bubble Sort
        int[] arr1 = original.clone();
        long start = System.nanoTime();
        bubbleSort(arr1);
        System.out.println("Bubble Sort Time: " + (System.nanoTime() - start) / 1000000.0 + " ms");

        // Test Quick Sort
        int[] arr2 = original.clone();
        start = System.nanoTime();
        quickSort(arr2, 0, n - 1);
        System.out.println("Quick Sort Time: " + (System.nanoTime() - start) / 1000000.0 + " ms");

        // Java's Built-in Sort (Dual-Pivot QuickSort)
        int[] arr3 = original.clone();
        start = System.nanoTime();
        Arrays.sort(arr3);
        System.out.println("Arrays.sort() Time: " + (System.nanoTime() - start) / 1000000.0 + " ms");
    }
}