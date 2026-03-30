package Solution;

/**
 * @author Miles
 * @date 2026/3/28 22:15
 */
public class Solution0011 {
    public int maxArea(int[] height) {
        int size = height.length;
        int left = 0;
        int right = size - 1;
        int max = 0;
        while (left < right) {
            int h = Integer.min(height[left], height[right]);
            int area = h * (right - left);
            max = Integer.max(max, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
