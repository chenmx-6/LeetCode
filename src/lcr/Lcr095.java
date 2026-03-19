package lcr;

/**
 * @author Miles
 * @date 2025/11/1 17:00
 */
public class Lcr095 {
    /*
     a b c d e
   a 1 1 1 1 1
   a 1 1 1 1 1
   c 1 1 2 2 2
   e 1 1 2 2 3
     */ 

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int max=0;
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        for (int i = 0; i < text1.length(); i++) {
            char c1 = charArray1[i];
            for (int j = 0; j < text2.length(); j++) {
                char c2 = charArray2[j];
                int left =0;
                int up =0;
                int leftUp=0;
                if(i!=0){
                    up=dp[i-1][j];
                }
                if(j!=0){
                    left=dp[i][j-1];
                }
                if(i!=0&&j!=0){
                    leftUp=dp[i-1][j-1];
                }
                if(c1==c2){
                    dp[i][j]=leftUp+1;
                }else{
                    dp[i][j]=Math.max(left,up);
                }
                max=Integer.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
