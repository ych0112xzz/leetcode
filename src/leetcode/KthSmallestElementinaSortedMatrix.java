package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ych0112xzz on 2016/10/26.
 */
public class KthSmallestElementinaSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {1, 6, 9}, {2, 6, 10}};
        int k = 3;
        System.out.println(new KthSmallestElementinaSortedMatrix().kthSmallest(matrix, k));
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxHeap.size() < k) {
                    maxHeap.add(matrix[i][j]);
                } else {
                    int tmp = maxHeap.peek();
                    if (matrix[i][j] >= tmp) {
                        break;
                    } else {
                        maxHeap.poll();
                        maxHeap.add(matrix[i][j]);
                    }
                }
            }
        }

        return maxHeap.peek();
    }


    /*
    * 将二维数组转化为一维数组，求一位数组的第k个元素
    * */
   /* int m;
    int n;

    public int kthSmallest(int[][] matrix, int k) {
//if m and n are very very large, then we only consider the top left matrix with width of k, since Kth element will never sit out side square k.
        m = Math.min(matrix.length, k);
        n = Math.min(matrix[0].length, k);
//quick selection range : start = 0, end = m*n-1;
        int kth = quickselect(matrix, 0, m * n - 1, k);
        return get(matrix, kth);
    }

    *//**
     * This function is a general quick selection, by using helper function of get and set, you can treat the indexes as are in a 1D array.
     *//*
    private int quickselect(int[][] matrix, int start, int end, int k) {
        int pivot = get(matrix, end);
        int left = start - 1;
        int right = end;
        while (true) {
            while (get(matrix, ++left) < pivot) ;
            while (right > 0 && get(matrix, --right) > pivot) ;
            if (left >= right) break;
            else {
                swap(matrix, left, right);
            }
        }
        swap(matrix, left, end);
        int num = left - start + 1;
        if (k == num) return left;
        else if (num > k) return quickselect(matrix, start, left - 1, k);
        else return quickselect(matrix, left + 1, end, k - num);
    }

    private int get(int[][] matrix, int index) {
        return matrix[index / n][index % n];
    }

    private void swap(int[][] matrix, int m1, int m2) {
        int tmp = matrix[m1 / n][m1 % n];
        matrix[m1 / n][m1 % n] = matrix[m2 / n][m2 % n];
        matrix[m2 / n][m2 % n] = tmp;
    }*/

}
