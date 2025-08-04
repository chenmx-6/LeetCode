package Solution;

/**
 * @Classname Solution1312
 * @Date 2025-7-31 16:48
 * @Created by ChenMX
 */
public class Solution1312 {
    public int minInsertions(String s) {
        int length = s.length();
        int[][] ints = new int[length][length];
        for (int i = 0; i < length; i++) {
            ints[i][i]=1;
        }
        char[] charArray = s.toCharArray();
        int max=1;
        for (int l = 2; l <= s.length(); l++) {
            for (int left = 0; left < s.length(); left++) {
                int right = left + l - 1;
                if(right>=length){
                    break;
                }
                char c1 = charArray[left];
                char c2 = charArray[right];
                int thisLength;
                if(c1==c2){
                    thisLength=ints[left+1][right-1]+2;
                }else{
                    thisLength=Math.max(ints[left][right-1],ints[left+1][right]);
                }
                ints[left][right]=thisLength;
                max=Math.max(thisLength,max);
            }
        }
        return length-max;
    }
}
