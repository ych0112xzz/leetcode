package leetcode;

/**
 * Created by ych0112xzz on 2016/11/25.
 */
public class RotateImage {
    /*public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] data = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = matrix[n-j-1][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = data[i][j];
            }
        }
    }*/


    /*
    *O(1)space
    * */
    public void rotate(int[][] matrix) {
        int tmp = 0;
        int n = matrix.length;
        int limit = n / 2;
        if(n%2!=0){
            limit = limit + 1;
        }
        for (int i = 0; i < limit; i++) {
            for (int j = i; j <= n-2-i; j++) {
                int leftOn=matrix[i][j];
                int rightOn = matrix[i][n - 2 - i];

            }
        }
    }
}
