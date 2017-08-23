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
            //插入到相等元素即停止，后面皆为重复
            if(i>0&&list.get(i-1)==nums[index]){
                break;
            }
            LinkedList<Integer> cur = new LinkedList<>(list);
            cur.add(i, nums[index]);
            permuteUnique(nums, index + 1, result, cur);
        }
    }

    /*public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<ArrayList<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<Integer>());
        for(int i=0;i<nums.length;i++){
            int len = result.size();
            for(int j=0;j<len;j++) {
                List<Integer> list = result.poll();
                for (int k = 0; k <= list.size(); k++) {
                    if(k>0&&list.get(k-1)==nums[i]){
                        break;
                    }
                    ArrayList<Integer> cur = new ArrayList<>(list);
                    cur.add(k, nums[i]);
                    result.offer(cur);
                }
            }
        }
        return (List)result;
    }*/
}
