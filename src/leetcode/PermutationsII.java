package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/12/26.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        permuteUnique(nums, 0, result, new LinkedList<Integer>());
        return result;
    }

    private void permuteUnique(int[] nums, int index, List<List<Integer>> result, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(list);
            return;
        }
        for (int i = 0; i <= list.size(); i++) {
            int tmp = list.size() == 0||i==list.size() ? -1 : list.get(i);
            LinkedList<Integer> cur = new LinkedList<>(list);
            cur.add(i, nums[index]);
            permuteUnique(nums, index + 1, result, cur);
            if (tmp == nums[index]) {
                break;
            }
        }
    }
}
