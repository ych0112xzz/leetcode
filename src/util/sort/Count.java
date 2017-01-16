package util.sort;

/**
 * Created by ych0112xzz on 2017/1/13.
 */
public class Count extends Sort {

    public static void main(String[] args) {
        // 检查排序结果
        int[] a = new int[] { 2,5,3,0,2,3,0,3 };
        int[] b = sort(a);
        assert isSorted(b);
        show(b);
    }

    public static int[] sort(int[] a) {
        int[] b = new int[a.length];
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            max = a[i] > max ? a[i] : max;
            min = a[i] < min ? a[i] : min;
        }

        int[] c = new int[max - min + 1];
        for(int i=0;i<a.length;i++) {
            c[a[i] - min]++;
        }
        for(int i=1;i<c.length;i++) {
            c[i] += c[i - 1];
        }

        for(int i=a.length-1;i>=0;i--) {
            b[--c[a[i]-min]]=a[i];
        }
        return b;
    }

    public static boolean isSorted(int[] a) {
        for(int i=1;i<a.length;i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
