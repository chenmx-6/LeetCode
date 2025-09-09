package Solution;

/**
 * @author Miles
 * @date 2025/8/30 0:04
 */
public class Solution0790 {
    static final int MOD = 1000000007;
    public int numTilings(int n) {
        int m=n;
        if(n<=3){
            m=3;
        }
        long[] dp = new long[m + 1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;
        for (int i = 4; i < m + 1; i++) {
            dp[i]=(2*dp[i-1]+dp[i-3])%MOD;
        }
        return (int) dp[n];
    }
}
