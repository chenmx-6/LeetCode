package Solution;

/**
 * @author Miles
 * @date 2025/8/17 22:22
 */
public class Solution0279 {
    public int numSquares(int n) {
        int[] r = new int[n + 1];
        for (int i = 1; i < n+1; i++) {
            r[i]=i;
            for (int j = 1; j*j <= i; j++) {
                r[i]=Math.min(r[i],r[i-j*j]+1);
            }
        }
        return r[n];
    }

    public static void main(String[] args) {
        Solution0279 solution0279 = new Solution0279();
        int i = solution0279.numSquares(12);
        System.out.println(i);
    }
}
