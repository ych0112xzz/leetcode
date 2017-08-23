package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ych0112xzz on 2017/5/10.
 */
public class PermutationSequence {

    public static void main(String[] args) {
        int n = 4;
        int k=14;
        System.out.println(getPermutation(n, k));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int factorial[] = new int[n + 1];
        factorial[0] = 1;
        for(int i=1;i<=n;i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            list.add(i);
        }
        k--;
        for (int i = 1; i <= n; i ++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(list.get(index)));
            list.remove(index);
            k = k % factorial[n - i];
        }
        return sb.toString();
    }
}
