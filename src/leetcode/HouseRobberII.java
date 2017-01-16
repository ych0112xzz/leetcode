package leetcode;

/**
 * Created by ych0112xzz on 2016/11/10.
 */
public class HouseRobberII {

    public static void main(String[] args) {
        int[] nums = {4,3,2,4,5,7,1};
        System.out.println(new HouseRobberII().rob(nums));
    }

    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(robber(nums,0,nums.length-1),robber(nums,1,nums.length));
    }

    public int robber(int[] nums,int start,int end){
        if(end-start==0){
            return 0;
        }
        if(end-start==1){
            return nums[start];
        }
        int[] dp = new int[end - start];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for(int i=2;i<end-start;i++){
            dp[i] = Math.max(dp[i - 2] + nums[i+start], dp[i - 1]);
        }
        return dp[dp.length-1];
    }
}
