package Solution;

/**
 * @Classname Solution0239
 * @Description TODO
 * @Date 2023-11-7 16:34
 * @Created by ChenMX
 */
public class Solution0239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length - k +1;
        int[] ints = new int[length];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if(i>0&&nums[i+k-1]>max){
                max=nums[i+k-1];
            }else{
                int[] tempInts = new int[k];
                for (int j = i,l=0; l < k; j++,l++) {
                    tempInts[l]=nums[j];
                }
                max=findMax(tempInts);
            }
            ints[i]=max;
        }
        return ints;
    }
    public int findMax(int[] nums){
        int max=Integer.MIN_VALUE;
        for (int num : nums) {
            max=Integer.max(max,num);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = {1,3,-1,-3,5,3,6,7};
        int[] ints1 = new Solution0239().maxSlidingWindow(ints, 3);
        for (int i : ints1) {
            System.out.println(i);
        }
    }
}
