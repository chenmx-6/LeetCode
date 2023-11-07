package hw;

import java.util.Scanner;

/**
 * @Classname HJ001
 * @Description TODO
 * @Date 2023-2-3 17:24
 * @Created by ChenMX
 */
public class HJ001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        StringBuilder stringBuilder = new StringBuilder();
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            stringBuilder.append(s);
        }
        String s = stringBuilder.toString();
        String substring = s.substring(s.lastIndexOf(" ")+1);
        System.out.println(substring.length());
    }
}
