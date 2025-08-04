package Solution;

/**
 * @Classname Solution1035
 * @Date 2025-7-31 16:34
 * @Created by ChenMX
 */
public class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] ints = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int c1 = nums1[i];
                int c2 = nums2[j];
                if(c1==c2){
                    int upLeft=0;
                    if(i!=0&&j!=0)upLeft=ints[i-1][j-1];
                    ints[i][j]=upLeft+1;
                }else{
                    int left=0;
                    int up=0;
                    if(j!=0)left=ints[i][j-1];
                    if(i!=0)up=ints[i-1][j];
                    ints[i][j]=Math.max(left,up);
                }
            }
        }
        return ints[nums1.length-1][nums2.length-1];
    }
}
