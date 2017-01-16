package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/12/27.
 */
public class SubsetsII {

    public static void main(String[] args) {
        int nums[] = {4, 4, 4, 1, 4};
        System.out.println(new SubsetsII().subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //result.add(new ArrayList<Integer>());
        List<Integer> list = new ArrayList<>();
        subsetsWithDup(nums, 0, result, list);
        return result;
    }

    private void subsetsWithDup(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        /*if (list.size() >= nums.length) {
            return;
        }
        int val = Integer.MIN_VALUE;
        for(int i=index;i<nums.length;i++) {
            if (val == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            result.add(new ArrayList<Integer>(list));
            subsetsWithDup(nums, i + 1, result, list);
            val=list.remove(list.size() - 1);
        }*/
        result.add(list);
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            List<Integer> nPath = new ArrayList<>(list);
            nPath.add(nums[i]);
            subsetsWithDup(nums, i + 1, result, nPath);
        }
    }

    /*
    * BFS
    * */
    /*public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        List<List<Integer>> prev = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> cur = new ArrayList<>();
            if (i > 0 && nums[i] == nums[i - 1]) {
                for (List<Integer> list : prev){
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(nums[i]);
                    cur.add(tmp);
                }
            }else{
                for (List<Integer> list : result) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(nums[i]);
                    cur.add(tmp);
                }
            }
            prev = cur;
            result.addAll(cur);
        }
        return result;
    }*/

}
