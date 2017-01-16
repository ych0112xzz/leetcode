package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/11/7.
 */
public class CountingBits {
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        int num=2147483646;
        int result[] = new CountingBits().countBits(num);
        for(int val:result){
            System.out.println(val);
        }

    }

   /* public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        int i = 1;
        int tem = 1;
        while (i <= num) {
            if(i/2==tem){
                result[i] = 1;
                tem = tem * 2;
            }else{
                result[i] = result[i - tem] + 1;
            }
            i++;
        }
        return result;
    }*/

    /*
    * 使用位
    * */

    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
