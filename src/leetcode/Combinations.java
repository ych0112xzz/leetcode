package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/7/27.
 */
public class Combinations {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 100000;
        int k = 10;
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    /*public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int i = 1;
        IntegerCom(n, k, i, result, list);

        return result;
    }

    public static void IntegerCom(int n, int k, int i, List<List<Integer>> result, List<Integer> list) {
        if (list.size() >= k) {
            List<Integer> list1 = new ArrayList<Integer>(list);//注意对象的引用
            result.add(list1);
            return;
        } else {

            for (int j = i; j<=n;j++) {
                list.add(j);
                IntegerCom(n, k, j + 1, result, list);
                list.remove(list.size() - 1);


            }
        }
    }*/


    /*
    * 利用关系C(n,k)=C(n-1,k-1)+C(n-1,k)，可改写为动态规划
    * */
   /* public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }*/


    /*
    * BFS(TLE)
    * */
/*    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<Integer>());
        int index = 0;
        for (int i = 0; i < k; i++) {
            int size = result.size();
            while (size-- > 0) {
                List<Integer> list = result.remove(0);
                index = list.size() == 0 ? 0 : list.get(list.size() - 1);
                for (int j = index + 1; j <= n; j++) {
                    ArrayList<Integer> tmp = new ArrayList<>(list);
                    tmp.add(j);
                    result.add(tmp);
                }
            }
        }
        return result;
    }*/
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int index = 1;
        while (index <= n || list.size() != 0) {
            if (list.size() == k) {
                result.add(new ArrayList<Integer>(list));
            }
            if (index > n || list.size() == k) {
                index = list.get(list.size() - 1) + 1;
                list.remove(list.size() - 1);
            }else{
                list.add(index);
                index++;
            }
        }
        return result;
    }

}
