package leetcode;

import java.util.Arrays;

/**
 * Created by ych0112xzz on 2016/11/29.
 */
public class Searcha2DMatrix {
    /*public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / n;
            int j = mid - i * n;
            if (matrix[i][j] < target) {
                start = mid + 1;
            } else if (matrix[i][j] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }*/

    /*
    *Array.binarySearch
    * */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0]) return false;
        int r = matrix.length, c = matrix[0].length, help[] = new int[r], i = 0;

        for (; i < r; i++) help[i] = matrix[i][c - 1];

        i = Arrays.binarySearch(help, target);
        if (i >= 0) return true;
        i = i < 0 ? -i - 1 : i;
        if (i > r - 1) return false;
        // target bigger than the last one in last row
        i = Arrays.binarySearch(matrix[i], target);
        return i >= 0;
    }
}
