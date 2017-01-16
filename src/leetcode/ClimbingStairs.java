package leetcode;

/**
 * Created by ych0112xzz on 2016/9/20.
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int i = 1;
        int j = 2;
        int result = 0;
        for(int k = 0;k<n-2;k++){
            result = i + j;
            i = j;
            j = result;
        }

        return result;

    }
}
