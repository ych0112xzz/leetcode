package leetcode;

/**
 * Created by ych0112xzz on 2016/11/7.
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args){
        int n = 100;
        System.out.println(new UniqueBinarySearchTrees().numTrees(n));
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //dp[1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] +=dp[j]*dp[i - 1 - j];
            }
        }

        return dp[n];
    }
}
