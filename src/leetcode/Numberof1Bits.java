package leetcode;

/**
 * Created by ych0112xzz on 2016/10/31.
 */
public class Numberof1Bits {
    /*public int hammingWeight(int n) {
        int result = 0;
        for(int i=0;i<32;i++){
            if((n & 1)!=0){
                result++;
            }
            n >>= 1;
        }
        return result;
    }*/

    /*public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int p = n & -n;
            n ^= p;
            count++;
        }
        return count;
    }*/

    public int hammingWeight(int n) {
        int count = 0;
        while ( n != 0 ) {
            n = n & n-1;
            count++;
        }
        return count;
    }
}
