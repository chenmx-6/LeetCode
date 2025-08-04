package Solution;

/**
 * @Classname Solution1143
 * @Date 2025-7-31 15:58
 * @Created by ChenMX
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] ints = new int[text1.length()][text2.length()];
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                char c1 = charArray1[i];
                char c2 = charArray2[j];
                if(c1==c2){
                    int upLeft=0;
                    if(i!=0&&j!=0)upLeft=ints[i-1][j-1];
                    ints[i][j]=upLeft+1;
                }else{
                    int left=0;
                    int up=0;
                    if(j!=0)left=ints[i][j-1];
                    if(i!=0)up=ints[i-1][j];
                    ints[i][j]=Math.max(left,up);
                }
            }
        }
        return ints[text1.length()-1][text2.length()-1];
    }
}
