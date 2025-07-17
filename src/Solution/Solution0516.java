package Solution;

import com.sun.javafx.image.IntPixelGetter;

/**
 * @Classname Solution0516
 * @Date 2025-7-17 10:16
 * @Created by ChenMX
 */
public class Solution0516 {

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] r = new int[length][length];
        for (int i = 0; i < length; i++) {
            r[i][i]=1;
        }
        int max=1;
        char[] charArray = s.toCharArray();
        for (int l = 2; l <= length; l++) {
            for (int i = 0; i < length; i++) {
                int j=i+l-1;
                if(j>=length){
                    break;
                }
                int thisLength;
                if(charArray[i]==charArray[j]){
                    thisLength=r[i+1][j-1]+2;
                }else{
                    thisLength=Integer.max(r[i+1][j],r[i][j-1]);
                }
                r[i][j]=thisLength;
                max= Integer.max(thisLength,max);
            }
        }
        return max;
    }
}
