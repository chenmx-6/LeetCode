package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Solution0120
 * @Date 2025-7-15 14:08
 * @Created by ChenMX
 */
public class Solution0120 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row=triangle.get(i);
            ArrayList<Integer> nums = new ArrayList<>();
            if(i==0){
                nums.add(row.get(0));
                lists.add(nums);
                continue;
            }
            List<Integer> lastRow = lists.get(i - 1);
            for (int j = 0; j < row.size(); j++) {
                if(j==0){
                    nums.add(row.get(j)+lastRow.get(0));
                }else if(j==(row.size()-1)){
                    nums.add(row.get(j)+lastRow.get(lastRow.size()-1));
                }else{
                    nums.add(Integer.min(lastRow.get(j-1),lastRow.get(j))+row.get(j));
                }
            }
            lists.add(nums);
        }
        List<Integer> nums = lists.get(lists.size() - 1);
        for (Integer num : nums) {
            min=Integer.min(num,min);
        }
        return min;
    }
}
