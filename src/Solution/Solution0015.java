package Solution;

import java.util.ArrayList;
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
}
