package Solution;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Classname Solution0128
 * @Description TODO
 * @Date 2023-11-6 11:32
 * @Created by ChenMX
 */
public class Solution0128 {
    public int longestConsecutive(int[] nums) {
        int max= 0;
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        for (Integer integer : integers) {
            if(integers.contains(integer-1)){
                max=Integer.max(max,1);
            }else{
                int i=1;
                while(integers.contains(integer+1)){
                    i++;
                    integer++;
                }
                max=Integer.max(i,max);
            }
        }
        return max;
    }
}
