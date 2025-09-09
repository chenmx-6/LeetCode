package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution0215 {
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (Integer num : nums) {
            integers.add(num);
        }
        return quickSort(integers,k);
    }

    public int quickSort(List<Integer> nums, int k){
        Random random = new Random();
        int pivot = nums.get(random.nextInt(nums.size()));
        List<Integer> big = new ArrayList<Integer>();
        List<Integer> equals = new ArrayList<Integer>();
        List<Integer> small = new ArrayList<Integer>();
        for (Integer num : nums) {
            if(num>pivot){
                big.add(num);
            }else if(num==pivot){
                equals.add(num);
            }else{
                small.add(num);
            }
        }
        if(k<=big.size()){
            return quickSort(big,k);
        }else if(k<=(big.size()+equals.size())){
            return pivot;
        }else{
            return quickSort(small,k-(big.size()+equals.size()));
        }
    }
}
