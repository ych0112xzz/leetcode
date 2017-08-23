package interview.yuanjing;

import java.util.HashMap;
import java.util.HashSet;

/*
Question 2
 */
public class Sum {
    public static int getCommonSum(int[] a, int[] b) {
        if (a == null || b == null) {
            return 0;
        }
        HashSet<Integer> aHash = new HashSet<>();
        for (int ele : a) {
            aHash.add(ele);
        }

        int sum = 0;
        for (int ele : b) {
            if (aHash.contains(ele)) sum += ele;
        }
        return sum * 2;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 2, 3};
        int[] b = {2, 2, 2,5, 6, 3, 4};
        System.out.println(getCommonSum(a, b));
    }
}
