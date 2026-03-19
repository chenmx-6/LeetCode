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
}
