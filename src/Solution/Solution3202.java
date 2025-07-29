package Solution;

/**
 * @Classname Solution3202
 * @Date 2025-7-17 16:57
 * @Created by ChenMX
 */
public class Solution3202 {
    public int maximumLength(int[] nums, int k) {
        int[][] r = new int[k][k];
        int max=0;
        for (int num : nums) {
            num%=k;
            for (int i = 0; i < k; i++) {
                r[i][num]=r[num][i]+1;
                max=Math.max(r[i][num],max);
            }
        }
        return max;
    }
}
