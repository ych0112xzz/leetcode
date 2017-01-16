package leetcode;

/**
 * Created by ych0112xzz on 2016/9/22.
 */
public class Pow {

    public static void main(String[] args) {
        System.out.println(myPow(3.0, -2));
    }

    public static double myPow(double x, int n) {
        double result = 1.0d;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == Integer.MIN_VALUE) {
            result = myPow(x, Integer.MAX_VALUE) * x;
        } else if (n % 2 == 0) {
            result = myPow(x * x, Math.abs(n) / 2);
        } else {
            result = myPow(x * x, Math.abs(n) / 2) * x;
        }

        return n > 0 ? result : (1 / result);
    }
}
