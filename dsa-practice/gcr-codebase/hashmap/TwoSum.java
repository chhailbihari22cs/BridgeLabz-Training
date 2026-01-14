import java.util.*;

public class TwoSum {

    // Static method taaki seedha call ho sake
    public static int[] findIndices(int[] nums, int target) {
        // Map store karega: Value -> Index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Agar complement diary (map) mein mil gaya
            if (map.containsKey(complement)) {
                // Complement ka index aur aaj ka index return karo
                return new int[] { map.get(complement), i };
            }

            // Nahi toh aaj ka number aur index diary mein likh lo
            map.put(nums[i], i);
        }

        // Agar kuch na mile toh khali array bhej do
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = findIndices(nums, target);

        if (result.length == 2) {
            System.out.println("Indices mile: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Koi pair nahi mila.");
        }
    }
}
