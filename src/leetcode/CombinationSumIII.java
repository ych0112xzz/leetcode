package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/12/27.
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        int k=3;
        int target = 10;
        System.out.println(new CombinationSumIII().combinationSum3(k, target));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum3(k, n, list, result, 1);
        return result;
    }

    private void combinationSum3(int k, int target, List<Integer> list, List<List<Integer>> result, int start) {
        if (target < 0||list.size() > k) {
            return;
        }
        if (target == 0) {
            if (list.size() == k) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            combinationSum3(k, target - i, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
