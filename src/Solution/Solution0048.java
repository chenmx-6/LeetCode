package Solution;

/**
 * @author chenmx
 * @date 2026-4-1
 **/

public class Solution0048 {
    public void rotate(int[][] matrix) {
        //1 2 3     7 4 1
        //4 5 6     8 5 2
        //7 8 9     9 6 3

        //1 4 7
        //2 5 8
        //3 6 9
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(j>i){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }

        int mid=length/2;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < mid; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][length-j-1];
                matrix[i][length-j-1]=temp;
            }
        }

    }
}
