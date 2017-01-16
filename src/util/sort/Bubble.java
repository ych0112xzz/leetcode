package util.sort;

/**
 * Created by ych0112xzz on 2017/1/12.
 */
public class Bubble extends Sort{

    public static void main(String[] args) {
        String[] b = new String[] { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        sort(b);

        assert isSorted(b);
        show(b);
    }

    public static void sort(Comparable[] a) {
        int len = a.length;
        for(int i=0;i<len-1;i++) {
            for(int j=1;j<len;j++) {
                if(less(a[j],a[j-1])){
                    exch(a,j,j-1);
                }
            }
        }
    }
}
