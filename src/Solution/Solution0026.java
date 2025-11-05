package Solution;

import sun.text.resources.cldr.ti.FormatData_ti;

/**
 * @author Miles
 * @date 2025/11/1 17:38
 */
public class Solution0026 {

    public int removeDuplicates(int[] nums) {
        int left=1;
        int right=1;
        while(right<nums.length){
            if(nums[right]!=nums[left-1]){
                nums[left]=nums[right];
                left++;
            }
            right++;
        }
        return left;

    }
}
