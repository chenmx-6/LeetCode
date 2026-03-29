package Solution;

import java.util.*;

public class Solution0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int rightNum = nums[right];
                int leftNum = nums[left];
                if (leftNum + rightNum > -nums[i]) {
                    for (int j = right; j >= 0; j--) {
                        if (nums[j] != rightNum || j == 0) {
                            right = j;
                            break;
                        }
                    }
                } else if (leftNum + rightNum < -nums[i]) {
                    for (int j = left; j < nums.length; j++) {
                        if (nums[j] != leftNum || j == nums.length - 1) {
                            left = j;
                            break;
                        }
                    }
                } else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(leftNum);
                    integers.add(rightNum);
                    lists.add(integers);
                    for (int j = left; j < nums.length; j++) {
                        if (nums[j] != leftNum || j == nums.length) {
                            left = j;
                            break;
                        }
                    }
                    for (int j = right; j >= 0; j--) {
                        if (nums[j] != rightNum || j == 0) {
                            right = j;
                            break;
                        }
                    }
                }
            }
            for (int j = i; j < nums.length; j++) {
                if (nums[j] != nums[i] || j == nums.length - 1) {
                    i = j;
                    break;
                }
            }
        }
        return lists;
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ) {
            int num1 = nums[i];
            int left = i + 1;
            if (num1 + nums[left] > 0) {
                break;
            }
            int right = nums.length - 1;
            while (left < right) {
                int num2 = nums[left];
                int total = num2 + nums[right] + num1;
                if (total > 0) {
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(num2);
                    list.add(nums[right]);
                    lists.add(list);
                    while (left < right && num2 == nums[left]) {
                        left++;
                    }
                }
            }
            while (i < nums.length && num1 == nums[i]) {
                i++;
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int num1 = nums[i];
            if (num1 > 0) break;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int num2 = nums[left];
                int num3 = nums[right];
                int total = num2 + num3 + num1;
                if(total<0){
                    while(left<nums.length&&nums[left]==num2){
                        left++;
                    }
                }else if(total>0){
                    while(right>=left&&nums[right]==num3){
                        right--;
                    }
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(num2);
                    list.add(num3);
                    lists.add(list);
                    while(left<nums.length&&nums[left]==num2){
                        left++;
                    }
                }
            }
            while(i<nums.length&&nums[i]==num1){
                i++;
            }
        }
        return lists;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution0015 solution0015 = new Solution0015();
        solution0015.threeSum3(nums);
    }


}
