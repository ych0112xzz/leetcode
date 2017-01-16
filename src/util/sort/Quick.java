package util.sort;

/**
 * Created by ych0112xzz on 2017/1/12.
 */
public class Quick extends Sort {

    public static void main(String[] args) {
        String[] b = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        sort(b);

        assert isSorted(b);
        show(b);
    }

    public static void sort(Comparable[] a){
        sort3way(a, 0, a.length - 1);
    }

    /**
     *
     * @param a
     * @param lo
     * @param high
     */
    private static void sort(Comparable[] a, int lo, int high) {
        if (lo >= high) {
            return;
        }
        Comparable key = a[lo];
        int i=lo;
        int j = high+1;
        while (true) {
            while (less(a[++i], key)) {
                if (i == high) {
                    break;
                }
            }
            while (less(key, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        sort(a, lo, j - 1);
        sort(a, j + 1, high);
    }


    /**
     * 三向切分的快速排序算法：它从左到右遍历数组一次，维护一个指针lt使得a[lo..lt-1]中的元素都小于v，一个指针gt使得a[gt+1..hi]
     * 中的元素都大于v，一个指针i使得a[lt..i-1]中的元素都等于v，a[i..gt]中的元素都还未确定。
     * @param a 排序数组
     * @param lo 起始索引
     * @param high  结束索引
     */
    public static void sort3way(Comparable[] a, int lo, int high) {
        if (lo >= high) {
            return;
        }
        int lt = lo, i = lo + 1, gt = high;
        Comparable key = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(key);
            if (cmp < 0) {
                exch(a,i++,lt++);
            }else if (cmp > 0) {
                exch(a, i, gt--);
            }else{
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, high);

    }
}
