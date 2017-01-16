package leetcode;

/**
 * Created by ych0112xzz on 2016/11/29.
 */
public class Sqrt {

    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(5 * 1.0 / 2);
        System.out.println(new Sqrt().mySqrt(x));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1;
        int end = 2;
        while (end < x * 1.0 / end) {
            start = end;
            end <<= 1;
        }
        if (end * end == x) {
            return end;
        }
        System.out.println(start + "\t" + end);
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < x * 1.0 / mid) {
                start = mid + 1;
            } else if (mid > x * 1.0 / mid) {
                end = mid;
            } else {
                return mid;
            }
            System.out.println(start + "\t" + mid + "\t" + end);
        }
        return start - 1;
    }
}
