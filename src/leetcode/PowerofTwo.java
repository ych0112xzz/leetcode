package leetcode;

/**
 * Created by ych0112xzz on 2017/3/14.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        n =n&(n-1);
        return n==0;
    }
}
