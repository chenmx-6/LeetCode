package Solution;

/**
 * @Classname Solution0300
 * @Date 2025-7-23 18:21
 * @Created by ChenMX
 */
public class Solution0300 {
    public int lengthOfLIS(int[] nums) {
        int[] ints = new int[nums.length];
        int maxLength=1;
        ints[0]=1;
        for (int i = 0; i < nums.length; i++) {
            int max=0;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    max=Math.max(max,ints[j]);
                }

            }
            ints[i]=max+1;
            maxLength=Integer.max(max+1,maxLength);
        }
        return maxLength;
    }
}
