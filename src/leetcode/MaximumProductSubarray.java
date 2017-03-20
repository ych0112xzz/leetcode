package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/9/28.
 */
public class MaximumProductSubarray {

    public static void main(String[] args){
        int[] nums = {1, 2, -3, 4,0,5,6,-1,4,-2,0,4,2};
        System.out.print(new MaximumProductSubarray().maxProduct(nums));
    }

    /*private int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result =nums[0];
        int tmp=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                result = Math.max(result, 0);
                tmp = 1;
            }else{
                tmp *= nums[i];
                result = Math.max(result, tmp);
            }
        }
        tmp = 1;


        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0){
                result = Math.max(result, 0);
                tmp = 1;
            }else{
                tmp *= nums[i];
                result = Math.max(result, tmp);
            }
        }

        return result;
    }*/

    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

//    public int maxProduct(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int result = 1;
//        int zeroRt = 1;
//        int nagRt = 1;
//        int tmp = 1;
//        int total = 1;
//        List<Integer> list = new ArrayList<>();
//        boolean isPos = true;
//        for (int i = 0; i < nums.length; i++) {
//
//
////            if (isPos) {
////                result = tmp;
////            }
//
//            if (nums[i] == 0) {
//                if (nums[i - 1] > 0) {
//                    list.add(tmp);
//                }
//                Collections.sort(list);
//                if (total > 0) {
//                    result = total;
//
//                } else if (list.get(list.size() - 1) > 0) {
//                    if (list.get(list.size() - 2) > list.get(0))
//                        result = total / list.get(list.size() - 2);
//                    else result = total / list.get(0);
//                } else if (list.get(list.size() - 1) > list.get(0)) {
//                    result = total / list.get(list.size() - 1);
//                } else {
//                    result = total / list.get(0);
//                }
//                total = 1;
//                zeroRt = result > zeroRt ? result : zeroRt;
//                tmp = 1;
//            }
//            total = total * nums[i];
//            tmp = tmp * nums[i];
//            if (nums[i] < 0) {
//                isPos = false;
//                list.add(tmp);
//                tmp = 1;
//            }
//
//        }
//        if (nums[nums.length - 1] > 0) {
//            list.add(tmp);
//        }
//
//        Collections.sort(list);
//        if (total > 0) {
//            result = total;
//        } else if (list.get(list.size() - 1) > 0) {
//            if (list.get(list.size() - 2) > list.get(0))
//                result = total / list.get(list.size() - 2);
//            else result = total / list.get(0);
//        } else if (list.get(list.size() - 1) > list.get(0)) {
//            result = total / list.get(list.size() - 1);
//        } else {
//            result = total / list.get(0);
//        }
//        zeroRt = result > zeroRt ? result : zeroRt;
//        return zeroRt;
//    }
}
