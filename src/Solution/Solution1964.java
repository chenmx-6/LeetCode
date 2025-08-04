package Solution;

import java.util.Arrays;

/**
 * @Classname Solution1964
 * @Date 2025-7-31 9:55
 * @Created by ChenMX
 */
public class Solution1964 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] ints = new int[obstacles.length];
        int[] less = new int[obstacles.length];
        Arrays.fill(less, Integer.MAX_VALUE);
        int res=0;
        for (int i = 0; i < obstacles.length; i++) {
            int left=0;
            int right=res;
            int obstacle = obstacles[i];
            while(left<right){
                int mid = (left + right) / 2;
                if(obstacle>=less[mid] ){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            less[left]=obstacle;
            ints[i]=left+1;
            if(left>=res){
                res++;
            }
        }
        return ints;
    }
}
