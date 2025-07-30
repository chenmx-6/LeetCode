package Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution1027
 * @Date 2025-7-29 18:00
 * @Created by ChenMX
 */
public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int maxNum=1;
        for (int i = 0; i < nums.length; i++) {
            maxNum=Math.max(maxNum,nums[i]);
        }
        Map<Integer,Map<Integer, Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> currentMap = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j];
                Map<Integer, Integer> dMap = map.get(j);
                int maxLength=0;
                if(dMap.containsKey(d)){
                    Integer q = dMap.get(d);
                    currentMap.put(d,q+1);
                    maxLength=q+1;
                }else{
                    currentMap.put(d,1);
                    maxLength=1;
                }
                max=Math.max(maxLength,max);
            }
            map.put(i,currentMap);
        }
        return max+1;
    }
}
