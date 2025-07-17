package Solution;

/**
 * @Classname Solution0221
 * @Date 2025-7-15 18:12
 * @Created by ChenMX
 */
public class Solution0221 {
    public int maximalSquare(char[][] matrix) {
        int[][] r = new int[matrix.length][matrix[0].length];
        int max=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='0'){
                    r[i][j]=0;
                    continue;
                }
                int leftUp=0;
                int left=0;
                int up=0;
                if(i!=0){
                    up=r[i-1][j];
                }
                if(j!=0){
                    left=r[i][j-1];
                }
                if(i>0&&j>0){
                    leftUp=r[i-1][j-1];
                }
                int min = Integer.min(left, leftUp);
                min=Integer.min(min,up);
                int square = 1+ min;
                r[i][j]=square;
                max=Integer.max(square,max);
            }
        }
        return max*max;
    }
}
