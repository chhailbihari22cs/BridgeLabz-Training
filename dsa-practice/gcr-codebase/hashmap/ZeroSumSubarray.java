import java.util.*;

public class ZeroSumSubarray {

    // Simple static method bina kisi OOPS ke
    public static void findAllSubarrays(int[] arr) {
        // Map store karega: Cumulative Sum -> List of Indices jahan ye sum mila
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

            // Case 1: Agar sum khud 0 ho jaye, matlab index 0 se i tak ek subarray hai
            if (sum == 0) {
                System.out.println(" we find subArray: Index 0 se " + i);
            }

            // Case 2: Agar ye sum humein pehle bhi mil chuka hai
            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int oldIndex : indices) {
                    System.out.println("Subarray mil gaya: Index " + (oldIndex + 1) + " se " + i);
                }
            }

            // Current sum ko map mein daalo (Index ke saath)
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        
        System.out.println("Zero Sum Subarrays ki list:");
        findAllSubarrays(arr);
    }
}
