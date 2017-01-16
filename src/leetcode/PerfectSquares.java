package leetcode;

/**
 * Created by ych0112xzz on 2016/11/14.
 */
public class PerfectSquares {

    public static void main(String[] args) {
        int n = 25;
        System.out.println(new PerfectSquares().numSquares(n));
    }



    /*
    * O(n*n)
    * */
   /* public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(Math.sqrt(i)-(int)Math.sqrt(i)==0){
                dp[i] = 1;
            }else{
                dp[i] = Integer.MAX_VALUE;
                for(int j=1;j<=i/2;j++){
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }

        return dp[n];
    }*/

    /*public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int prev =(int) Math.sqrt(i);
           // System.out.println(prev);
            int tmp = i - prev*prev;
            if(tmp==0){
                dp[i] = 1;
            }else {
                dp[i] = dp[prev * prev] + dp[tmp];
                for (int j = 2; j < prev; j++) {
                    dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
                }
            }
        }
        return dp[n];
    }*/

    /*
    * 设置static变量
    * */

    public static int[] dp;

    public int numSquares(int n) {
        int size = 0;
        if (dp == null) {
            dp = new int[n + 1];
        } else if (dp.length <= n) {
            size = dp.length;
            int[] temp = new int[n + 1];
            for (int i = 0; i < dp.length; i++) {
                temp[i] = dp[i];
            }
            dp = temp;
        }

        for (int i = size; i <= n; i++) {
            int prev = (int) Math.sqrt(i);
            // System.out.println(prev);
            int tmp = i - prev * prev;
            if (tmp == 0) {
                dp[i] = 1;
            } else {
                dp[i] = dp[prev * prev] + dp[tmp];
                for (int j = 2; j < prev; j++) {
                    dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
                }
            }
        }


        return dp[n];
    }


}
