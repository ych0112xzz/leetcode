package interview.wangyi;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by ych0112xzz on 2017/3/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) {
            nums[i] = s.nextInt();
        }
        Arrays.sort(nums);
        int result=0;
        /*if(canPartition(nums)){
            for (int num : nums) {
                result += num;
            }
            System.out.println(result/2);
        }else{
            System.out.println(-1);
        }*/
        result = canPartition(nums);
        if(result>500000){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }



    }


    public static int canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        int result = volumn / 2;
        if (volumn % 2 != 0) {
            return -1;
        }
        volumn /= 2;
        // dp def

        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        int max = 0;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];

            }
        }
        for(int k=0;k<dp.length;k++) {
            if(dp[k]){
                max = k;
            }
        }
        if(max>=0){
            return max;
        }else{
            return -1;
        }
        /*if(dp[volumn]){
            return result;
        }else{
            return -1;
        }*/
    }

  /*  public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 == 1) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        // deal with the first row
        if(nums[0] <= target) dp[0][nums[0]] = true;

        // deal with the first col
        for(int i = 0; i < nums.length; i++) dp[i][0] = true;

        // deal with the rest
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }*/


    /* public static void canPartition(int[] nums,BitSet bitSet,int sum) {
       *//* int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }*//*
        *//*if(sum%2==1){
            return false;
        }*//*
       *//* BitSet bitSet = new BitSet(sum+1);
        bitSet.set(0);*//*
        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=nums[i];j--){
                boolean isSum = bitSet.get(j) || bitSet.get(j - nums[i]);
                if(isSum){
                    bitSet.set(j);
                }
            }
        }
    }*/
}
