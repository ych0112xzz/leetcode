package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/11/15.
 */
public class HIndex {
    /*public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]<(result+1)){
                return result;
            }else{
                result++;
            }
        }
        return result;
    }*/

    public int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }

        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length] += 1;
            } else {
                array2[citations[i]] += 1;
            }
        }
        int t = 0;
        int result = 0;

        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }

}
