import java.util.HashSet;

public class PairSum {
    
    // Static method: Bina object banaye call karne ke liye
    public static boolean hasPair(int[] arr, int target) {
        // HashSet jo numbers ko yaad rakhega
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            // Agar complement pehle hi set mein hai, toh pair mil gaya
            if (set.contains(complement)) {
                System.out.println("Pair mil gaya: (" + num + ", " + complement + ")");
                return true;
            }

            // Current number ko set mein daal do taaki aage kaam aaye
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 16;

        if (!hasPair(arr, target)) {
            System.out.println("Koi pair nahi mila.");
        }
    }
}