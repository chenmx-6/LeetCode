package Solution;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Classname Solution1218
 * @Date 2025-7-29 16:35
 * @Created by ChenMX
 */
public class Solution1218 {

    public int longestSubsequence(int[] arr, int difference) {
        int[] r = new int[arr.length];
        Arrays.fill(r,1);
        int max=1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] - difference;
            if(map.containsKey(key)){
                r[i]=map.get(key)+1;
            }
            map.put(arr[i],r[i]);
            max=Math.max(r[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = {};
        Solution1218 solution1218 = new Solution1218();
        int i = solution1218.longestSubsequence(ints, 5692);
        System.out.println(i);
    }
}
