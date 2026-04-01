package Solution;

/**
 * @author Miles
 * @date 2026/3/31 21:32
 */
public class Solution0238 {
    public int[] productExceptSelf(int[] nums) {

        //1 2 3 4

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                res[i] = res[i - 1] * nums[i - 1];
            } else {
                res[i] = 1;
            }
        }

        int sum=1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sum*=nums[i+1];
            res[i]=res[i]*sum;
        }
        return res;
    }
}
