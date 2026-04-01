package Solution;

/**
 * @author chenmx
 * @date 2026-3-31
 **/

public class Solution0053 {

    public int maxSubArray(int[] nums) {
        int[] ints = new int[nums.length];
        int min=0;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            ints[0]=sum;
            min=Integer.min(sum,min);
            sum+=nums[i];
            if(sum-min>max){
                max=sum-min;
            }
        }
        return max;
    }


    public int maxSubArray2(int[] nums) {
        int[] ints = new int[nums.length];
        int max=nums[0];
        ints[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            ints[i]=Integer.max(ints[i-1],0)+nums[i];
            max=Integer.max(max,ints[i]);
        }
        return max;
    }

}
