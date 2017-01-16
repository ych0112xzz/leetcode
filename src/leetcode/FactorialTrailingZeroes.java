package leetcode;

/**
 * Created by ych0112xzz on 2016/9/27.
 */
public class FactorialTrailingZeroes {


    public static void main(String[] args) {
        int n = 25;
//        long result = 1;
//        for (int i = 1; i <= n; i++) {
//            result *= i;
//        }
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(n));
    }

    public int trailingZeroes(int n) {
        int result = 0;
        int tmp =5;
        while(tmp<=n){
            result +=n/tmp;
            n /= 5;
        }
        return result;

    }
}
