package Solution;

import java.util.HashMap;

/**
 * @author chenmx
 * @date 2026-3-30
 **/

public class Solution0930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0;
        int r=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(sum,map.getOrDefault(sum, 0)+1);
            sum+=nums[i];
            r+=map.getOrDefault(sum-goal,0);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] ints={1,0,1,0,1};
        Solution0930 solution0930 = new Solution0930();
        int i = solution0930.numSubarraysWithSum(ints,2);
        System.out.println(i);
    }

}
