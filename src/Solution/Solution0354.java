package Solution;

import java.util.Arrays;

/**
 * @Classname Solution0354
 * @Date 2025-7-30 15:39
 * @Created by ChenMX
 */
public class Solution0354 {
    public int maxEnvelopes(int[][] envelopes) {
        int[] r = new int[envelopes.length];
        Arrays.fill(r,Integer.MAX_VALUE);
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int max=0;
        for (int i = 0; i < envelopes.length; i++) {
            int h = envelopes[i][1];
            int left=0;
            int right=max;
            while(left<right){
                int mid = (left + right) / 2;
                if(h>r[mid]){
                    left=mid+1;
                } else {
                    right=mid;
                }
            }
            r[left]=h;
            if(left>=max){
                max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] envolopes={{5,4},{6,4},{6,7},{2,3},{2,3},{1,1},{1,1}};
        Solution0354 solution0354 = new Solution0354();
        int i = solution0354.maxEnvelopes(envolopes);
        System.out.println(i);
    }

}
