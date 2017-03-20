package leetcode;

/**
 * Created by ych0112xzz on 2017/3/14.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int result=x^y;
        int count=0;
        while(result!=0){
            result &=(result-1);
            count++;
        }

        return count;
    }
}
