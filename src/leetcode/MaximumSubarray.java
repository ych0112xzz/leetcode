package leetcode;

/**
 * Created by ych0112xzz on 2016/11/1.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }


    /*
    * */
    /*public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int tmp=nums[0];
        if(tmp<0){
            tmp = 0;
        }
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            int cur = tmp + nums[i];

            result = result >= cur ? result : cur;
            tmp = cur >= 0 ? cur : 0;
        }
        return result;
    }*/

    /*
    * 分而治之
    * */
    /**
     *  for example:  array = [-2,1,-3]
     *                max = 1
     *                lMax = -1
     *                rMax = -2
     *                sum = -4
     */
   /* private class ArrayContext {
        int max; // max sum of the sub array
        int lMax; // max sum begins with the leftmost element
        int rMax; // max sum ends with the rightmost element
        int sum; // sum of all elements

    }

    public ArrayContext getArrayContext(int[] nums, int l, int r) {
        ArrayContext ctx = new ArrayContext();
        if (l == r) {
            // only one element
            ctx.max = nums[l];
            ctx.lMax = nums[l];
            ctx.rMax = nums[l];
            ctx.sum = nums[l];
        } else {
            int m = (l + r) / 2;
            ArrayContext lCtx = getArrayContext(nums, l, m);
            ArrayContext rCtx = getArrayContext(nums, m + 1, r);

            // the max sum of sub array  would be the max of:
            // 1. max of the left sub array
            // 2. max of the right sub array
            // 3. rMax of the left sub array + lMax of the right sub array
            ctx.max = Math.max(Math.max(lCtx.max, rCtx.max), lCtx.rMax + rCtx.lMax);
            ctx.lMax = Math.max(lCtx.lMax, lCtx.sum + rCtx.lMax);
            ctx.rMax = Math.max(rCtx.rMax, rCtx.sum + lCtx.rMax);
            ctx.sum = lCtx.sum + rCtx.sum;
        }

        return ctx;
    }


    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        ArrayContext ctx = getArrayContext(nums, 0, nums.length - 1);
        return ctx.max;
    }*/

    /*
    * 动态规划
    * */
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
