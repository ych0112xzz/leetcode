package util.sort;

import leetcode.Combinations;

/**
 * Created by ych0112xzz on 2017/1/13.
 */
public class Heap extends Sort {


    public static void main(String[] args) {
        String[] b = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(b);

        assert isSorted(b);
        show(b);
    }

    /**
     * @param a 待排序数组
     * @param k 位置索引
     * @param N 数组长度
     *//*
    public static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int i = 2 * k;
            if (i < N && less(a[i], a[i + 1])) {
                i++;
            }
            if (!less(a[k], a[i])) {
                break;
            }
            exch(a, k, i);
            k = i;
        }
    }


    */

    /**
     * 堆原始定义，数组第一位为空
     *
     * @param a
     *//*
    public static void sort(Comparable[] a) {
        int len = a.length;
        Comparable[] b = new Comparable[a.length + 1];
        for(int i=1;i<b.length;i++) {
            b[i] = a[i - 1];
        }
        for (int k = len / 2; k >= 1; k--) {
            sink(b, k, len);
        }

        //堆排序，相当于删除每次最大元素
        while (len > 1) {
            exch(b, 1, len--);
            sink(b, 1, len);
        }
        for(int i=0;i<a.length;i++) {
            a[i] = b[i + 1];
        }
    }*/


    public static void sort(Comparable[] a) {
        int N = a.length;
        //构造堆
        for (int k = N / 2; k >= 1; k--)
            sink(a, k, N);
        //堆排序，相当于删除每次最大元素
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    public static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j+1)) {
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = tmp;
    }

    public static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }


}
