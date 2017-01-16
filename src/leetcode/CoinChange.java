package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/10/26.
 */
public class CoinChange {


    public static void main(String[] args) {
        int coins[] = {288,160,10,249,40,77,314,429};
        int amount=9208;
        System.out.println(new CoinChange().coinChange(coins,amount));
    }


/*
* 动态规划
* */
  /*  public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        *//*for(int i=0;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }*//*
        dp[0]=0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<coins.length;j++){
                if (coins[j] <= i&&dp[i-coins[j]]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }*/

    /*
    * 递归,time limited
    * */
    /*public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0]=0;
        return coinChange(coins, amount, dp);
    }

    public int coinChange(int[] coins, int amount, int[] dp) {
        if(amount<0){
            return -1;
        }
        if(dp[amount]!=Integer.MAX_VALUE){
            return dp[amount];
        }
        for (int i = 0; i < coins.length; ++i) {
            int tmp = coinChange(coins, amount - coins[i], dp);
            if(tmp>=0){
                dp[amount] = Math.min(dp[amount], tmp + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }*/


    /*
    * 递归
    * */
    int total = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        count(amount, coins.length-1, coins, 0);
        return total == Integer.MAX_VALUE?-1:total;
    }
    void count(int amount, int index, int[] coins, int count){
        if (index<0 || count>=total-1) return;
        int c = amount/coins[index];
        for (int i = c;i>=0;i--){
            int newCount = count + i;
            int rem = amount - i*coins[index];

            if (rem>0 && newCount<total)
                count(rem, index-1, coins, newCount);
            else{
                total = newCount<total?newCount:total;
                break;
            }
        }
    }
}
