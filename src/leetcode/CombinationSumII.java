package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/12/26.
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int candidates[] = {10,1,2,7,6,1,5,3,1,2,4};
        int target = 8;
        System.out.println(new CombinationSumII().combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum2(candidates, 0, target, result,list);
        return result;
    }

    private void combinationSum2(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        int val = -1;
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i]==val) {
                continue;
            }
            list.add(candidates[i]);
            combinationSum2(candidates, i + 1, target - candidates[i], result, list);
            val = list.remove(list.size() - 1);
        }
    }
}
