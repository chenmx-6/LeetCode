package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        HashSet<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(integerSet.contains(nums[i])){
                continue;
            }
            for (int j = i+1; j < nums.length - 1; j++) {
                if(integerSet.contains(nums[j])){
                    continue;
                }
                for (int k = j+1; k < nums.length; k++) {
                    if(integerSet.contains(nums[k])){
                        continue;
                    }
                    int all = nums[i] + nums[j] + nums[k];
                    if(all==0){
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        lists.add(integers);
                        integerSet.add(nums[i]);
                        integerSet.add(nums[j]);
                        integerSet.add(nums[k]);
                    }
                }
            }
        }
        return lists;
    }



    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; ) {
            int num1 = nums[i];
            int left=i+1;
            if(num1+nums[left]>0){
                break;
            }
            int right=nums.length-1;
            while(left<right){
                int num2 = nums[left];
                int total = num2 + nums[right] + num1;
                if(total>0){
                    right--;
                }else if(total<0){
                    left++;
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(num2);
                    list.add(nums[right]);
                    lists.add(list);
                    while(left<right&&num2==nums[left]){
                        left++;
                    }
                }
            }
            while(i<nums.length&&num1==nums[i]){
                i++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        Solution0015 solution0015 = new Solution0015();
        solution0015.threeSum2(nums);
    }


}
