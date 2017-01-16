package leetcode;

/**
 * Created by ych0112xzz on 2016/9/14.
 */
public class IntegerBreak {

    public static void main(String[] args){
        int n=10;
        System.out.println(integerBreak(n));
    }

    /*public static int integerBreak(int n) {
        int result=0;
        if(n==2){
            return 1;
        }
        if(n==3) {
            return 2;
        }
        int a=n/3;
        int b=n%3;
        if(b==1||b==0){
            result = (int) (Math.pow(3, a - 1) * (3 + b));
        }else{
            result=(int)(Math.pow(3,a)*b);
        }

        return result;
    }*/

    /*
    * 动态规划
    * */

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }
        return dp[n];
    }
}
