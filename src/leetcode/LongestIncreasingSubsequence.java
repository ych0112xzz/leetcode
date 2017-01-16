package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/11/14.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

    /*
    * O(n*n)
    * */
    /*public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int max = 1;
       // Arrays.fill(dp, 1);
        for(int i=1;i<dp.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max = max >= dp[i] ? max : dp[i];
        }
        return max;
    }*/

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            //System.out.println(x+"**");
            int i = Arrays.binarySearch(dp, 0, len, x);
          //  System.out.println(i);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            System.out.println(i+"\t"+dp[i]+"\t"+len);
            if (i == len) len++;
        }

        return len;
    }
}
