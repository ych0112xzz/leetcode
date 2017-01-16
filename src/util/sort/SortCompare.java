package util.sort;


import java.util.Random;

/**
 * 计算不同和排序算法的时间
 * Created by ych0112xzz on 2017/1/12.
 */
public class SortCompare {

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Shell";
        String alg3 = "Selection";
        String alg4 = "Merge";
        int N=200;
        int T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        double t3 = timeRandomInput(alg3, N, T);
        double t4 = timeRandomInput(alg4, N, T);
        System.out.println("Insertion Time:" + t1);
        System.out.println("Shell Time:" + t2);
        System.out.println("Selection Time:" + t3);
        System.out.println("Merge Time:" + t4);

    }

    /**
     * 计算排序时间
     * @param alg 排序算法
     * @param a
     * @return
     */
    public static double time(String alg, Comparable[] a) {
        long start = System.nanoTime();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        if(alg.equals("Shell")) Shell.sort(a);
        if(alg.equals("Merge")) Merge.sortBU(a);
        long now = System.nanoTime();
        return (now-start)/1000000000.0;
    }

    /**
     * 使用alg将T个数组长度为N的数组排序
     * @param alg 所使用的排序算法
     * @param N 数组长度
     * @param T 生成T个长度为N的随机数组
     * @return
     */
    public static double timeRandomInput(String alg, int N, int T) {

        double total = 0.0;
        Double[] a = new Double[N];//不能是double，必须为对象
        for(int i=0;i<T;i++) {
            for(int j=0;j<N;j++) {
                long seed = System.nanoTime();
                Random random = new Random(seed);
                a[j] = random.nextDouble();
            }
//            if(i==0&&alg.equals("Insertion")) Insertion.show(a);
            total += time(alg, a);
        }
        return total;
    }
}
