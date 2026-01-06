class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>i;j--){
                if(nums[i]+nums[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;

    }
}
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {5, 4 ,6,3,7};

        Solution s = new Solution();
        System.out.println(s.twoSum(arr,7));
    }
}
