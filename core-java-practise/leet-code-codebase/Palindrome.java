class Solution2 {
    public boolean isPalindrome(int x) {
        int x2 = x;
        int rem =1;
        String str = "";
        int reverse = 0;
        if(x<0){
            return false;
        }
        while(x!=0){
            rem = x%10;
            reverse = reverse*10 + rem;
            x = x/10;
        }
        return reverse==x2;


    }
}

public class Palindrome {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.isPalindrome(1412));
    }
}
