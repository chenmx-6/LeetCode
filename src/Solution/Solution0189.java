package Solution;

/**
 * @author chenmx
 * @date 2026-3-31
 **/

public class Solution0189 {

    public void rotate(int[] nums, int k) {
        swap(nums, 0, nums.length - 1);
        k=k%nums.length;
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length-1);
    }

    public void swap(int[] nums, int begin, int end) {
        //1 2 3
        //3 2 1
        //3 1 2
        int mid = ((begin + end)-1) / 2;
        int j = 0;
        for (int i = begin; i <= mid; i++) {
            if(end-j>nums.length-1||i>nums.length-1)continue;
            int temp = nums[i];
            nums[i] = nums[end - j];
            nums[end - j] = temp;
            j++;
        }
    }
}
