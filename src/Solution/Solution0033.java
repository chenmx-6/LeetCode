package Solution;

/**
 * @author Miles
 * @date 2025/11/8 23:21
 */
public class Solution0033 {
    public int search(int[] nums, int target) {
        //56781234
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = (left + right) / 2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[0]) {
                 if(nums[mid]>=target&&target>=nums[0]){
                     right=mid-1;
                 }else{
                     left=mid+1;
                 }
            }else{
                if(nums[mid]<=target&&target<nums[0]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
