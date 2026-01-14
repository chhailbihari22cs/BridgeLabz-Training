import java.util.HashSet;

public class LongestSequence {

    public static int findLongest(int[] nums) {
        // Step 1: Saare numbers ko HashSet mein daal do fast lookup ke liye
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Step 2: Array ko traverse karo
        for (int num : nums) {
            // Check karo: Kya ye number sequence ka start hai?
            // Agar num-1 set mein nahi hai, matlab yahan se ginti shuru ho sakti hai
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStack = 1;

                // Jab tak agla number milta jaye, ginte raho
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStack++;
                }

                // Sabse badi length ko update karo
                if (currentStack > longest) {
                    longest = currentStack;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        
        int result = findLongest(arr);
        System.out.println("Sabse lambi consecutive ginti ki length: " + result);
    }
}