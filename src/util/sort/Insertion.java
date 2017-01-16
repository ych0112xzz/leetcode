package util.sort;

import leetcode.Combinations;

/**
 * 插入排序：对于数组，左边为有序数组，右边为待插入数组，将待插入数组依次插入左边有序的数组
 * Created by ych0112xzz on 2017/1/12.
 */
public class Insertion extends Sort{

    public static void main(String[] args) {
//        int a[] = {3};
        String[] b = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        sort(b);
        /*for (int p : a) {
            System.out.print(p + " ");
        }*/
        assert isSorted(b);
        show(b);
    }

    public static void sort(Comparable[] a) {
        int len = a.length;
        for(int i=1;i<len;i++) {
            for(int j=i;j>0&&less(a[j],a[j-1]);j--) {
                exch(a, j, j - 1);
            }
        }
    }


    public static void sort(int a[]) {
        int len = a.length;
        for(int i=1;i<len;i++) {
            for(int j=i;j>0&&a[j]<a[j-1];j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void exch(int a[], int i, int j) {
        int tmp=a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
