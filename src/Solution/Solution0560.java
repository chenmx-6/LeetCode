package Solution;

import com.sun.javafx.image.IntPixelGetter;

import java.util.HashMap;

/**
 * @author chenmx
 * @date 2026-3-30
 **/

public class Solution0560 {
    public int subarraySum(int[] nums, int k) {
        int res=0;
        int sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(sum,map.getOrDefault(sum,0)+1);
            sum+=nums[i];
            res+=map.getOrDefault(sum-k,0);
        }
        return res;
    }
}
