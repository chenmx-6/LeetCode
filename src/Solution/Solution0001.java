package Solution;

/**
 * @Classname Solution0001
 * @Description TODO
 * @Date 2022-11-24 14:41
 * @Created by ChenMX
 */
public class Solution0001 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]+num==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }





















    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    int[] ints = new int[2];
                    ints[0]=i;
                    ints[1]=j;
                    return ints;
                }
            }
        }
        return new int[2];
    }
}
