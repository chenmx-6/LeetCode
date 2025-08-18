package Solution;

/**
 * @author Miles
 * @date 2025/8/18 20:13
 */
public class Solution0474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] r = new int[m + 1][n + 1];
        r[0][0] = 1;
        int max=1;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            int quantityM = 0;
            int quantityN = 0;
            for (int j = 0; j < charArray.length; j++) {
                if (charArray[j] == '0') {
                    quantityM++;
                } else {
                    quantityN++;
                }
            }
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (r[j][k] != 0) {
                        if ((j + quantityM) <= m && (k + quantityN) <= n) {
                            r[j + quantityM][k + quantityN] = Math.max(r[j][k] + 1, r[j + quantityM][k + quantityN]);
                            max=Math.max(max,r[j + quantityM][k + quantityN]);
                        }
                    }
                }
            }
        }
        return max-1;
    }


    public static void main(String[] args) {
        Solution0474 solution0474 = new Solution0474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int maxForm = solution0474.findMaxForm(strs, 5, 3);
        System.out.println(maxForm);
    }
}
