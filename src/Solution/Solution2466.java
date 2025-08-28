package Solution;

import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * @author Miles
 * @date 2025/8/20 0:12
 */
public class Solution2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1_000_000_007;
        int min = Math.min(zero, one);
        long[] dp = new long[high+1];
        dp[0]=1;
        for (int i = min; i <= high; i++) {
            long num0=0;
            if(i-zero>=0){
                num0=dp[i-zero];
            }
            long num1=0;
            if(i-one>=0){
                num1=dp[i-one];
            }
            dp[i]=(num0+num1)%MOD;
        }
        int r=0;
        for (int i = low; i <= high; i++) {
            r+=dp[i];
            r%= MOD;
        }
        return r%MOD;
    }
}
