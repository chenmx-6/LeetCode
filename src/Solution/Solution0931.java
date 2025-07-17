package Solution;

/**
 * @Classname Solution0931
 * @Date 2025-7-15 17:33
 * @Created by ChenMX
 */
public class Solution0931 {
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int[] lastRow=null;
            if(i==0){
                continue;
            }else{
                lastRow=matrix[i-1];
            }
            for (int j = 0; j < row.length; j++) {
                int left=Integer.MAX_VALUE;
                int middle=lastRow[j];
                int right=Integer.MAX_VALUE;
                if(j>0){
                    left=lastRow[j-1];
                }
                if(j<row.length-1){
                    right=lastRow[j+1];
                }
                int min = Integer.min(left, middle);
                min=Integer.min(min,right);
                matrix[i][j]+=min;
            }
        }
        int r=Integer.MAX_VALUE;
        for (int i = 0; i < matrix[matrix.length - 1].length; i++) {
            r=Integer.min(r,matrix[matrix.length - 1][i]);
        }
        return r;
    }

    public static void main(String[] args) {
        int a[][]={{-19,57},{-40,-5}};
        int i = new Solution0931().minFallingPathSum(a);
        System.out.println(i);
    }
}
