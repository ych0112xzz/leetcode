package leetcode;



/**
 * Created by ych0112xzz on 2016/9/14.
 */
public class PowerofThree {

    public static boolean isPowerOfThree(int n) {

        double result =  (Math.log10(n) / Math.log10(3));
        return (result-(int)result)==0?true:false;
    }
}
