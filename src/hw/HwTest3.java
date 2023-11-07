package hw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname HwTest3
 * @Description TODO
 * @Date 2023-2-4 13:05
 * @Created by ChenMX
 */
public class HwTest3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[][] ints = new int[m][m];
        int taskNum = scanner.nextInt();
        for (int i = 0; i < taskNum; i++) {
            int j = scanner.nextInt();
            int k = scanner.nextInt();
            ints[k][j]=1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(1!=ints[i][j])ints[i][j]=0;
            }
        }
        int longest=0;
        for (int i = 0; i < m; i++) {
            longest=Integer.max(longest,getLongestWay(ints,i));
        }
        System.out.println(longest);
    }
    public static int getLongestWay(int[][] ints, int i){
        int length=0;
        for (int j = 0; j < ints[i].length; j++) {
            length+=ints[i][j];
        }
        if(length==0)return 0;
        int longestLength=0;
        for (int j = 0; j < ints[i].length; j++) {
            if(ints[i][j]==1){
                longestLength=Integer.max(longestLength,getLongestWay(ints,j)+1);
            }
        }
        return longestLength+1;
    }
}
