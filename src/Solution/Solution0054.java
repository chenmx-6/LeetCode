package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miles
 * @date 2025/11/1 23:36
 */
public class Solution0054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int width= matrix[0].length;
        int high=matrix.length;
        int total = width * high;
        int index=0;
        int length=width;
        for (int i = 0; i < total; i++) {
            if(index<length) {
                list.add(matrix[index][width]);
            }
        }
        return list;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        ArrayList<Integer> res = new ArrayList<>();
        while(top<=bottom&&left<=right){
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <=bottom ; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if(top>bottom){
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(left>right){
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints={{7},{9},{6}};
        Solution0054 solution0054 = new Solution0054();
        List<Integer> res = solution0054.spiralOrder2(ints);
        System.out.println(res);
    }
}
