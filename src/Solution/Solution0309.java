package Solution;

/**
 * @Classname Solution0309
 * @Date 2025-8-1 11:10
 * @Created by ChenMX
 */
public class Solution0309 {
    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int[] ints = new int[prices.length-1];
        for (int i = 0; i < ints.length; i++) {
            ints[i]=prices[i+1]-prices[i];
        }
        int[] r = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            int left=0;
            if(i>=1){
                left=r[i-1];
            }
            int leftRes=0;
            if(i>=3){
                leftRes=r[i-3];
            }
            if(i>=1&&ints[i-1]<0){
                if(ints[i - 1] + ints[i] >= 0&&r[i-1]!=0) {
                    int leftRes2=0;
                    if(i>=2){
                        leftRes2=r[i-2];
                    }
                    r[i]=Math.max(leftRes+ints[i],leftRes2+ints[i-1]+ints[i]);
                }else{
                    r[i]=Math.max(leftRes+ints[i],left);
                }
            }else{
                r[i]=Math.max(left+ints[i],left);
            }
        }
        return r[r.length-1];
    }

    public static void main(String[] args) {
        int[] prices={2,1,4,5,2,9,7};
        Solution0309 solution0309 = new Solution0309();
        int i = solution0309.maxProfit(prices);
        System.out.println(i);
    }
}
