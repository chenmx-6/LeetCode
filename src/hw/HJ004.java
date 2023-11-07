package hw;

import java.util.Scanner;

/**
 * @Classname HJ004
 * @Description TODO
 * @Date 2023-2-3 18:08
 * @Created by ChenMX
 */
public class HJ004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (str.length()>0){
            if(str.length()>=8){
                String substring = str.substring(0, 8);
                System.out.println(substring);
                str=str.substring(8);
            }else if(str.length()>0){
                int remain=8-str.length();
                for (int i = 0; i < remain; i++) {
                    str=str+"0";
                }
                System.out.println(str);
                break;
            }
        }

    }
}
