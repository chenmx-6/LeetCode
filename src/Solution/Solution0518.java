package Solution;

import com.sun.javafx.robot.FXRobotImage;

import java.util.HashSet;

/**
 * @author Miles
 * @date 2025/8/17 23:15
 */
public class Solution0518 {
    public int change(int amount, int[] coins) {
        int[] r = new int[amount + 1];
        r[0]=1;
        for (int coin : coins) {
            for (int i = 1; i <=amount ; i++) {
                int j = i - coin;
                if(j<0)continue;
                r[i]+=r[j];
            }
        }
        return r[amount];
    }


    public static void main(String[] args) {
        Solution0518 solution0518 = new Solution0518();
        int[] ints = {1, 2, 5};
        int change = solution0518.change(5, ints);
        System.out.println(change);
    }
}
