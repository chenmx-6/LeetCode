package Solution;

/**
 * @Classname Solution0673
 * @Date 2025-7-23 18:10
 * @Created by ChenMX
 */
public class Solution0673 {
    public int findNumberOfLIS(int[] nums) {
        int[] ints = new int[nums.length];
        int[] quantity = new int[nums.length];
        ints[0]=1;
        int maxLength=1;
        for (int i = 0; i < nums.length; i++) {
            ints[i]=1;
            quantity[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    if(ints[i]<ints[j]+1){
                        ints[i]=ints[j]+1;
                        quantity[i]=quantity[j];
                    }else if(ints[i]==ints[j]+1){
                        quantity[i]+=quantity[j];
                    }
                }
            }
            maxLength=Integer.max(ints[i],maxLength);
        }
        int ans=0;
        for (int i = 0; i < quantity.length; i++) {
            if(maxLength==ints[i])ans+=quantity[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = {2,2,2,2,2};
        Solution0673 solution0673 = new Solution0673();
        int numberOfLIS = solution0673.findNumberOfLIS(ints);
        System.out.println(numberOfLIS);
    }
}
