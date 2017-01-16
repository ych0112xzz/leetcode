package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/9/29.
 */
public class MissingNumber {

    /*
    * 排序数组，二分查找
    * */

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start =0;
        int end = nums.length;
        int mid = 0;
        while(start<end){
            mid = start + (end - start) / 2;
            if(mid>=nums.length){
                return mid;
            }
            if(nums[mid]==mid){
                start = mid+1;
            }else{
                end = mid;
            }
        }

//        for(i=0;i<nums.length;i++){
//            if(nums[i]!=i){
//                break;
//            }
//        }
        return start;

    }

    /*
    * 使用位运算，使用异或
    * */

    /*public int missingNumber(int[] nums) {
        int result=0;
        int i = 0;
        for(i=0;i<nums.length;i++){
            result ^= nums[i] ^ i;
        }
        result ^= i;
        return result;
    }*/

    /*
    * 使用sum计算前n项和
    *
    * */
}
