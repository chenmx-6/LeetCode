package Solution;

import java.util.Arrays;

/**
 * @Classname Solution0646
 * @Date 2025-7-29 16:17
 * @Created by ChenMX
 */
public class Solution0646 {
    public int findLongestChain(int[][] pairs) {
        int[] r = new int[pairs.length];
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        Arrays.fill(r,1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if(pairs[i][0]>pairs[j][1]){
                    r[i]=Math.max(r[i],r[j]+1);
                }
            }
        }
        return r[pairs.length-1];
    }
}
