package util.sort;

import leetcode.Combinations;

import java.util.Comparator;

/**
 * Created by ych0112xzz on 2017/1/12.
 */
public class Merge extends Sort{
    public static void main(String[] args) {
        String[] b = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        sortBU(b);

        assert isSorted(b);
        show(b);
    }

    private static Comparable[] aux;
    public static void sort(Comparable[] a) {
        int len = a.length;
        aux = new Comparable[len];
        sort(a, 0, len - 1);
    }


    /**
     * 自顶而下的归并
     * @param a
     * @param start
     * @param end
     */
    private static void sort(Comparable[] a, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(a, start, mid);
        sort(a, mid + 1, end);
        merge(a, start, mid, end);
    }


    /**
     * 原地归并的抽象方法
     * @param a
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(Comparable[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        for(int k=start;k<=end;k++) {
            aux[k] = a[k];
        }
        for(int k=start;k<=end;k++) {
            if(i>mid){
                a[k] = aux[j++];
            }else if(j>end){
                a[k] = aux[i++];
            }else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }
    }


    /**
     * 自底而上的归并算法
     * @param a
     */
    public static void sortBU(Comparable[] a) {
        int len = a.length;
        aux = new Comparable[len];
        for(int sz=1;sz<len;sz=sz+sz) {
            for(int lo=0;lo<len-sz;lo +=sz+sz) {
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,len-1));
            }
        }

    }
}
