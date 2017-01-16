package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/7/27.
 */
public class CombinationsBetter {
    public static Integer[] num;
    public static Integer[] stack;
    public static int target;

    public static ArrayList<List<Integer>> found;

    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 6;
        int k = 3;
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
        long end = System.nanoTime();
        System.out.println(end - start + "ns");

    }


    public static void search(int p){
        if(p == target){
            found.add(new ArrayList<Integer>(Arrays.asList(stack)));
            return;
        }

        for(Integer n : num){
            if(p > 0 && n <= stack[p - 1]) continue;//使用n <= stack[p - 1]控制下次循环n的起点

            stack[p] = n;
            search(p + 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {

        target = k;

        num = new Integer[n];
        for(int i = 1; i <= n; i++) num[i - 1] = i;

        stack = new Integer[k];

        found = new ArrayList<List<Integer>>();

        search(0);

        return found;
    }
}
