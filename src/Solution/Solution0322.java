package Solution;

/**
 * @Classname Solution0322
 * @Description TODO
 * @Date 2023-10-15 21:31
 * @Created by ChenMX
 */
public class Solution0322 {
    public static void main(String[] args) {
        int i = coinChange(new int[]{2}, 0);
        System.out.println(i);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] results = new int[amount + 1];
        results[0]=0;
        for (int i = 1; i <= amount; i++) {
            int min=-1;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                int lastCoin = i - coin;
                if(lastCoin >=0&&results[lastCoin]!=-1){
                    int currentCoin = results[lastCoin] + 1;
                    if(min==-1){
                        min= currentCoin;
                    }else{
                        min=Integer.min(min,currentCoin);
                    }
                }
            }
            results[i]=min;
        }
        return results[amount];
    }

}
