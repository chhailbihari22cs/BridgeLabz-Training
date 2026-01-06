class Solution4{
    public int reverse(int x) {
        int rn = 0;
        while (x != 0) {
            int rem = x % 10;
            x = x / 10;


            if (rn > Integer.MAX_VALUE / 10 || (rn == Integer.MAX_VALUE / 10 && rem > 7)) {
                return 0;
            }
            if (rn < Integer.MIN_VALUE / 10 || (rn == Integer.MIN_VALUE / 10 && rem < -8)) {
                return 0;
            }

            rn = rn * 10 + rem;
        }
        return rn;
    }
}

public class ReverseInteger {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.reverse(45325));
    }
}
