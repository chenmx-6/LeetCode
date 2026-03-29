package Solution;

/**
 * @author Miles
 * @date 2026/3/28 16:54
 */
public class Solution0283 {
    public void moveZeroes(int[] nums) {
        int left =0;
        int right=0;
        while(left<nums.length&&right<nums.length){
            if(nums[left]==0&&nums[right]!=0){
                nums[left]=nums[right];
                nums[right]=0;
            }
            if(nums[left]!=0){
                left++;
            }
            if(nums[right]==0){
                right++;
            }
            if(right<=left){
                right=left;
            }
        }
    }
}
