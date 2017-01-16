package leetcode;

/**
 * Created by ych0112xzz on 2016/11/8.
 */
public class MaximalSquare {

    public static void main(String[] args){

    }

    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            if(matrix[i][0]=='1'){
                result = 1;
                dp[i][0] = 1;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i]=='1'){
                result = 1;
                dp[0][i] = 1;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1])+1;
                    if(dp[i][j]>result){
                        result = dp[i][j];
                    }
                }
            }
        }
        return result*result;
    }

    /*public int calDP(int i, int j, int k) {
        if(i==0||j==0||k==0){
            return 1;
        }
        if(i==j&&i==k){
            return i + 1;
        }
        return Math.min(Math.min(i,j),k)+1;
    }*/
}
