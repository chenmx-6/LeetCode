/**
 * @Classname Offer57Solution
 * @Description TODO
 * @Date 2022-11-24 15:00
 * @Created by ChenMX
 */
public class Offer57Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int result = nums[i] + nums[j];
            if(result<target){
                i++;
            }else if(result>target){
                j--;
            }else{
                return new int[]{nums[i],nums[j]};
            }
        }
        return null;
    }
}
