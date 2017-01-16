package util.sort;

/**
 * Created by ych0112xzz on 2017/1/12.
 */
public class Shell extends Sort{

    public static void main(String[] args) {
        String[] b = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        sort(b);

        assert isSorted(b);
        show(b);
    }

    public static void sort(Comparable[] a){
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for(int i=h;i<len;i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
