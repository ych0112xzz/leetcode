package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/11/30.
 */
public class MinimumSizeSubarraySum {

    /*
    * O(nlogn)
    * dp
    * */
   /* public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1;i<nums.length;i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        if(sum[nums.length-1]<s){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int dp[] = new int[sum.length];
        int i=0;
        for(i=0;i<dp.length;i++){
            if(sum[i]>=s){
                dp[i] = i + 1;
                break;
            }
        }
        if(dp[i]==1){
            return 1;
        }
        for(;i<dp.length;i++){
            for(int j=dp[i-1];j>1;j--) {
                if(sum[i]-sum[i-j+1]<s){
                    dp[i] = dp[i - 1];
                    break;
                }else{
                    result = Math.min(result,j-1);
                    dp[i] = result;
                }
            }
            if (dp[i-1]==1){
                return 1;
            }
        }
        return result;
    }*/


    /*
    * two pointer
    * */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, from = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - from + 1);
                sum -= nums[from++];
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

}
