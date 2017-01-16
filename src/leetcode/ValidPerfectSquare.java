package leetcode;

/**
 * Created by ych0112xzz on 2016/11/30.
 */
public class ValidPerfectSquare {
   /* public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0) {
            return true;
        }
        int low=0;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > num * 1.0 / mid) {
                high = mid - 1;
            } else if (mid < num * 1.0 / mid) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }*/

    /*
    * 牛顿法
    *
    * */
    public boolean isPerfectSquare(int num) { // O(1)
        // Newtons's method.
        // Find square root of num and square it
        // square == num ? true : false;

        long t = num;
        while (t * t > num) {
            t = (t + num / t) / 2;
        }
        return t * t == num;
    }
}
