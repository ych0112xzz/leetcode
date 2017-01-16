package leetcode;

/**
 * Created by ych0112xzz on 2016/9/23.
 */
//public class NumArray {
//    int[] nums;
//    int[] data;
//    public NumArray(int[] nums) {
//        this.nums = nums;
//        this.data = new int[nums.length];
//        for(int i =0;i<data.length;i++){
//            int p = 0;
//            for(int j=0;j<=i;j++){
//                p += nums[j];
//            }
//            data[i] = p;
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        int result=0;
//        result = data[j] - data[i]+nums[i];
////        i = i >= 0 ? i : 0;
////        j = j <= nums.length ? j : nums.length - 1;
////        for(int k =i;k<j+1;k++){
////            result += nums[k];
////        }
//        return result;
//    }
//}


public class NumArray {
    int[] nums;
    // int[] data;
    public NumArray(int[] nums) {
        this.nums = nums;
        int length = nums.length;
        for(int i =1;i<nums.length;i++){
            nums[i] +=nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        int result=0;
        if(i==0){
            return nums[j];
        }
        result = nums[j] - nums[i-1];
        // i = i >= 0 ? i : 0;
        // j = j <= nums.length ? j : nums.length - 1;
        // for(int k =i;k<j+1;k++){
        //     result += nums[k];
        // }
        return result;
    }
}
