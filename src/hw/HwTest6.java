package hw;

import java.util.Arrays;

public class HwTest6 {
    /**
     * 题目：
     * 给定一个长度为 n 的整数数组和一个目标值 target ，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
     * 示例 1：
     * 输入: nums = [-2,0,1,3], target = 2
     * 输出: 2
     * 解释: 因为一共有两个三元组满足累加和小于 2:
     *      [-2,0,1]
     *      [-2,0,3]
     * 条件:
     * 0 <= n <= 3500
     * -100 <= nums[i] <= 100
     * -100 <= target <= 100
     */
    public void getCount(){
        int[] nums={-2,0,1,3};
        int target=2;
        Arrays.sort(nums);
        if(nums.length<3){
            return;
        }
        int count=0;
        for (int i = 0; i < nums.length-2; i++) {
            int num1 = nums[i];
            for (int j = i+1; j < nums.length-1; j++) {
                int num2 = nums[j];
                int total = num1 + num2;
                if(total >=target){
                    break;
                }
                int difference = target - total;
                for (int k = j+1; k < nums.length; k++) {
                    int num3 = nums[k];
                    if(num3>=difference){
                        break;
                    }
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        HwTest6 hwTest6 = new HwTest6();
        hwTest6.getCount();
    }

    public void getCount2(){
        int[] nums={-2,0,1,3};
        int target=2;
        Arrays.sort(nums);
        if(nums.length<3){
            return;
        }
        int left=0;
        int right= nums.length-1;
        while(left<right){
            int num1 = nums[left];
            int num2 = nums[right];
            int total = num1 + num2;

        }


    }
}
