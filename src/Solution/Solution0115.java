package Solution;

/**
 * @Classname Solution0115
 * @Date 2025-7-23 17:02
 * @Created by ChenMX
 */
public class Solution0115 {

    public int numDistinct(String s, String t) {
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        int[][] ints = new int[charArray1.length+1][charArray2.length+1];
        for (int i = 0; i <= charArray1.length; i++) {
            ints[i][0]=1;
        }
        for (int i = 1; i <= charArray2.length; i++) {
            ints[0][i]=0;
        }
        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                char c1 = charArray1[i - 1];
                char c2 = charArray2[j - 1];
                if(c1==c2){
                    ints[i][j]=ints[i-1][j]+ints[i-1][j-1];
                }else{
                    ints[i][j]=ints[i-1][j];
                }
            }
        }
        return ints[charArray1.length][charArray2.length];
    }

    public static void main(String[] args) {
        Solution0115 solution0115 = new Solution0115();
        int i = solution0115.numDistinct("babgbag", "bag");
        System.out.println(i);
    }
}
