package leetcode;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by ych0112xzz on 2016/10/20.
 */
public class PartitionEqualSubsetSum {
    /*public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2==1){
            return false;
        }
        BitSet bitSet = new BitSet(sum+1);
        bitSet.set(0);
        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=nums[i];j--){
                boolean isSum = bitSet.get(j) || bitSet.get(j - nums[i]);
                if(isSum){
                    bitSet.set(j);
                }
            }
        }
        return bitSet.get(sum/2);
    }*/

    /*
    * 递归
    * */
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return true;
        if(nums.length == 1) return nums[0] == 0;

        Arrays.sort(nums);

        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(sum % 2 == 1) return false;
        int goal = sum/2;

        return helper(nums, nums.length-1, goal);
    }

    public boolean helper(int[] nums, int index, int sum) {
        if(sum < 0) return false;
        if(sum == 0) return true;
        for(int i = index; i >= 0; i--) {
            if(helper(nums, i-1, sum - nums[i])) {
                return true;
            }
        }
        return false;
    }

}
