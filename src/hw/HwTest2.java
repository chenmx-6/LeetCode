package hw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname HwTest2
 * @Description TODO
 * @Date 2023-2-4 12:28
 * @Created by ChenMX
 */
public class HwTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            int last = getLast(n, k+1);
            if(last==1){
                result.add("red");
            }else{
                result.add("blue");
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
    public static  int getLast(long n,long k){
        if(n==1){
            return 1;
        }
        double length = Math.pow(2, n - 1);
        double half = Math.pow(2, n - 2);
        if(k>half){
           return getLast(n-1,k-(int)half);
        }else{
            return -getLast(n-1,k);
        }
    }
}
