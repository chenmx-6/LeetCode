package hw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname HwTest1
 * @Description TODO
 * @Date 2023-2-4 11:42
 * @Created by ChenMX
 */
public class HwTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int n = scanner.nextInt();
        int l = string.length() / n;
        Character[][] chars = new Character[l + 1][n];
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if ((i / n) % 2 == 0) chars[i / n][i % n] = c;
            if ((i / n) % 2 == 1) chars[i / n][n - i % n - 1] = c;
        }


        for (int j = 0; j < n; j++) {
            for (int i = 0; i < l + 1; i++) {
                if (chars[i][j]!=null)System.out.print(chars[i][j]);
            }
            System.out.println();
        }

    }
}
