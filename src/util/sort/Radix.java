package util.sort;

/**
 * Created by ych0112xzz on 2017/1/16.
 */
public class Radix extends Sort {

    public static void main(String[] args) {
        int[] a = {21, 13, 56, 11, 1, 42, 4, 3, 64, 13, 0, 35, 11, 7, 17, 26, 120, 112, 365, 956, 212, 213};
        sort(a, 3);
        assert isSorted(a);
        show(a);
    }


    /**
     * @param a 待排序数组
     * @param d 数组里的最大值位数
     */
    public static void sort(int[] a, int d) {
        int index = 0;
        int len = a.length;
        int divisor = 1;//代表位数对应的数：1,10,100...
        int m = 1;
        int[][] data = new int[10][len];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶
        int[] row = new int[10];//用于保存每个桶里有多少个数字
        while (m <= d) {
            for (int tmp : a) {//将数组a里的每个数字放在相应的桶里
                int remain = (tmp / divisor) % 10;
                data[remain][row[remain]] = tmp;
                row[remain]++;
            }
            for (int i = 0; i < 10; i++) {//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
                if (row[i] != 0) {//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                    for (int j = 0; j < row[i]; j++) {
                        a[index] = data[i][j];
                        index++;
                    }
                    row[i] = 0;//将桶里计数器置0，用于下一次位排序
                }
            }
            divisor *= 10;
            index = 0;
            m++;
        }
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }


    public static void show(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
