package util.sort;

/**
 * Created by ych0112xzz on 2017/1/12.
 */
public class Sort {


    /**
     *比较元素
     * @param v
     * @param w
     * @return if(v<w)返回true
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     *将元素交换位置
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     *打印数组内容
     * @param a
     */
    public static void show(Comparable[] a) {
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    /*默认升序*/

    /**
     * 判断数组是否有序。assert isSorted(a)确认排序后的代码是有序的。
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for(int i=1;i<a.length;i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
