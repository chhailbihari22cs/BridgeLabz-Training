public class heapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        //  Build Max Heap (Rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //  One by one extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end (Swap)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i
    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left child
        int r = 2 * i + 2; // right child

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String args[]) {
        int salaries[] = {12, 11, 13, 5, 6, 7};
        heapSort hs = new heapSort();
        hs.sort(salaries);

        System.out.println("Sorted Salaries:");
        for (int s : salaries)
         System.out.print(s + " ");
    }
}