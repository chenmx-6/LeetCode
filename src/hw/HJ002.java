package hw;

import java.util.Scanner;

/**
 * @Classname HJ002
 * @Description TODO
 * @Date 2023-2-3 17:30
 * @Created by ChenMX
 */
public class HJ002 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str=str.toUpperCase();
        String target = in.nextLine();
        target=target.toUpperCase();
        int i=0;
        while(str.contains(target)){
            str=str.substring(str.indexOf(target)+target.length());
            i++;
        }
        System.out.println(i);
    }
}
