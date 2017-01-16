package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/12/29.
 */
public class CountNumberswithUniqueDigits {


    public static void main(String[] args) {
        int n = 1;
        System.out.println(new CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(n));
    }

    int result = 0;


    /*
    * 可以直接用公式C(9,1)*A(9.n-1)
    *
    * */

    /*
    * DFS
    * */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
         if(n>10){
            n=10;
        }
        List<Integer> list = new ArrayList<>();//可以将list换为boolean数组
        countNumbersWithUniqueDigits(list, n);
        return result;
    }

    private void countNumbersWithUniqueDigits(List<Integer> list, int n) {
        if (list.size() >= 1 && list.get(0) == 0 || list.size() == n) {
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            result++;
            countNumbersWithUniqueDigits(list, n);
            list.remove(list.size() - 1);
        }
    }

    /*
    * DP,使用/*
    * 可以直接用公式C(9,1)*A(9.n-1)
    *
    * */
}
