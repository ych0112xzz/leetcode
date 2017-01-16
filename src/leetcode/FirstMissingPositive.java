package leetcode;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by ych0112xzz on 2016/9/29.
 */
public class FirstMissingPositive {
    /*
    * 对数组data赋值时让其有序
    * */
    /*public int firstMissingPositive(int[] nums) {
        int[] data = new int[nums.length];
        //ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0&&nums[i]<=nums.length) {
                data[nums[i]-1] = nums[i];
            }
        }
        i = 0;
        for (i = 0; i < data.length; i++) {
            if (data[i]!= i + 1) {
                break;
            }
        }
        return i + 1;
    }*/

    /*
    * 使用bitset
    * */

    public int firstMissingPositive(int[] nums) {
        BitSet bitSet = new BitSet(nums.length);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                bitSet.set(nums[i]-1);
            }
        }

        return bitSet.nextClearBit(0);
    }

}
