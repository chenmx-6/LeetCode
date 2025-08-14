package Solution;

/**
 * @Classname Solution0096
 * @Date 2025-8-7 11:03
 * @Created by ChenMX
 */
public class Solution0096 {
    public int numTrees(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            int all=0;
            for (int j = 0; j < i; j++) {
                all+=dp[j]*dp[i-j-1];
            }
            dp[i]=all;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution0096 solution0096 = new Solution0096();
        int i = solution0096.numTrees(8);
        System.out.println(i);
    }
}
