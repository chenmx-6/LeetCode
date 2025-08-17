package Solution;

/**
 * @author Miles
 * @date 2025/8/18 0:22
 */
public class Solution0377 {
    public int combinationSum4(int[] nums, int target) {
        int[] r = new int[target + 1];
        r[0]=1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if(i<num)continue;
                r[i]+=r[i-num];
            }
        }
        return r[target];
    }

    public static void main(String[] args) {
        Solution0377 solution0377 = new Solution0377();
        int[] ints={1,2,3};
        int i = solution0377.combinationSum4(ints, 4);
        System.out.println(i);
    }
}
