package leetcode;

/**
 * Created by ych0112xzz on 2017/3/13.
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if(m==0){
            return false;
        }
        int n=matrix[0].length;
        int i=0,j=n-1;
        while(i<m&&j>=0){
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                j=j-1;
            }else{
                i=i+1;
            }
        }
        return false;
    }
}
