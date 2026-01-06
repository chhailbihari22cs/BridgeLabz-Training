class Solution3 {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            // Skip trailing spaces
            if (s.charAt(i) == ' ') {
                continue;
            }

            // Count the length of the last word
            while (i >= 0 && s.charAt(i) != ' ') {
                count++;
                i--;
            }

            break; // Exit the loop once the last word length is counted
        }

        return count;
    }
}


public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution3 s  = new Solution3();
        System.out.println(s.lengthOfLastWord("Hey my name is vishal"));
    }
}
