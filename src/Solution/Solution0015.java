package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2;) {
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
                        if (nums[j] != rightNum||j==0) {
                            right = j;
                            break;
                        }
                    }
                } else if (leftNum + rightNum < -nums[i]) {
                    for (int j = left; j < nums.length; j++) {
                        if (nums[j] != leftNum||j==nums.length-1) {
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
                        if (nums[j] != leftNum||j==nums.length) {
                            left = j;
                            break;
                        }
                    }
                    for (int j = right; j >= 0; j--) {
                        if (nums[j] != rightNum||j==0) {
                            right = j;
                            break;
                        }
                    }
                }
            }
            for (int j = i; j < nums.length; j++) {
                if (nums[j] != nums[i]||j==nums.length-1) {
                    i = j;
                    break;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution0015 solution0015 = new Solution0015();
        int[] nums = {0,0,0};
        List<List<Integer>> lists = solution0015.threeSum(nums);
        System.out.println(lists);
    }
}
