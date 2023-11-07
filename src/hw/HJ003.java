package hw;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname HJ003
 * @Description TODO
 * @Date 2023-2-3 17:37
 * @Created by ChenMX
 */
public class HJ003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int n = scanner.nextInt();
        while (scanner.hasNextInt()){
            set.add(scanner.nextInt());
        }
        Integer[] ints = set.toArray(new Integer[set.size()]);
        Arrays.sort(ints);
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }

    }
}
