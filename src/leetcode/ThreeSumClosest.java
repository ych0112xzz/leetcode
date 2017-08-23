package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2017/4/20.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result=0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            int lo=i+1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                int diff = Math.abs(target - sum);
                minDiff = Math.min(diff, minDiff);
                if (diff == minDiff) {
                    result = sum;
                }
                if(sum>target){
                    hi--;
                }else if(sum<target){
                    lo++;
                }else{
                    return sum;
                }
            }
        }
        return result;
    }

}
