package Solution;

/**
 * @Classname Solution0712
 * @Date 2025-7-22 17:01
 * @Created by ChenMX
 */
public class Solution0712 {

    public int minimumDeleteSum(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        int length1 = charArray1.length;
        int length2 = charArray2.length;
        int[][] ints = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }else if (j == 0) {
                    ints[i][j] = charArray1[i - 1] + ints[i - 1][j];
                }else if (i == 0) {
                    ints[i][j] = charArray2[j - 1] + ints[i][j - 1];
                }else{
                    char c1 = charArray1[i - 1];
                    char c2 = charArray2[j - 1];
                    int leftUp=0;
                    if(c1==c2){
                        leftUp=ints[i-1][j-1];
                    }else{
                        leftUp=ints[i-1][j-1]+c1+c2;
                    }
                    int left=ints[i][j-1]+c2;
                    int up=ints[i-1][j]+c1;
                    int min=Math.min(left,up);
                    min=Math.min(leftUp,min);
                    ints[i][j]=min;
                }
            }
        }
        return ints[length1][length2];
    }

    public static void main(String[] args) {
        Solution0712 solution0712 = new Solution0712();
        int r = solution0712.minimumDeleteSum("sea", "eat");
        System.out.println(r);
    }
}
