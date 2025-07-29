package Solution;

/**
 * @Classname Solution0072
 * @Date 2025-7-22 11:17
 * @Created by ChenMX
 */
public class Solution0072 {
    public int minDistance(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        int[][] ints = new int[charArray1.length + 1][charArray2.length + 1];
        for (int i = 0; i <= charArray1.length; i++) {
            ints[i][0]=i;
        }
        for (int i = 0; i <= charArray2.length; i++) {
            ints[0][i]=i;
        }
        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                char c1 = charArray1[i-1];
                char c2 = charArray2[j-1];
                int minLeftUp=0;
                if(c1==c2){
                    minLeftUp=ints[i-1][j-1]-1;
                }else{
                    minLeftUp=ints[i-1][j-1];
                }
                int min=Math.min(ints[i-1][j],ints[i][j-1]);
                min=Math.min(min,minLeftUp);
                ints[i][j]=min+1;
            }
        }
        return ints[charArray1.length][charArray2.length];
    }

    public static void main(String[] args) {
        Solution0072 solution0072 = new Solution0072();
        int r = solution0072.minDistance("horse", "ros");
        System.out.println(r);
    }
}
