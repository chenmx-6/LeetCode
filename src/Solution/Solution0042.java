package Solution;

import sun.text.resources.cldr.ti.FormatData_ti;

import java.rmi.server.RMIClassLoaderSpi;

/**
 * @author Miles
 * @date 2026/3/29 2:32
 */
public class Solution0042 {
    public int trap(int[] height) {
        int left=0;
        int right= height.length-1;
        int[] r = new int[height.length];
        while(left<right){
            int min = Integer.min(height[left], height[right]);
            for (int i = left+1; i < right; i++) {
                int w = min - height[i];
                r[i]=Integer.max(w,r[i]);
            }
            if(height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
            while(left< height.length&&height[left]==0){
                left++;
            }
            while(right>0&&height[right]==0){
                right--;
            }
        }
        int total=0;
        for (int i = 0; i < height.length; i++) {
            total+=r[i];
        }
        return total;
    }
}
