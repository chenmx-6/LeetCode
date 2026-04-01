package Solution;

/**
 * @author Miles
 * @date 2026/4/1 0:21
 */
public class Solution0041 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            swap(nums,nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private void swap(int[] nums,int num,int i){
        if(num<=0||num>nums.length){
            return;
        }
        if(nums[num-1]==num){
            return;
        }
        int temp = nums[num - 1];
        nums[num-1]=num;
        nums[i]=temp;
        swap(nums,temp,i);
    }

}
