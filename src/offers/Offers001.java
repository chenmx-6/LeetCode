package offers;

/**
 * @Classname Offers001
 * @Description TODO
 * @Date 2023-2-28 20:07
 * @Created by ChenMX
 */
public class Offers001 {
    public static void main(String[] args) {
        int divide = Offers001.divide(-2147483648, 1);
        System.out.println(divide);
    }

    public static int divide(int a, int b) {
        long c = (long) a;
        long d = (long) b;
        int r = 0;
        int k = 1;
        if (c < 0) {
            c = -c;
            k *= -1;
        }
        if (b < 0) {
            b = -b;
            k *= -1;
        }
        while (c >= b) {
            c -= b;
            r++;
            if(r==Integer.MAX_VALUE)break;
        }
        return r * k;
    }
}
