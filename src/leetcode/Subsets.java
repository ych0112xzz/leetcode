package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2016/12/26.
 */
public class Subsets {
    public static void main(String[] args) {
        int nums[] = {2, 1, 3};
        List<List<Integer>> result = new Subsets().subsets(nums);
        System.out.println(result);
    }

    /*
    * DFS,和combinations一样的思路
    * */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        result.add(new ArrayList<Integer>(list));
        int len = nums.length;
//        for (int k = 0; k < len; k++) {//去掉循环，令k=len,在递归时就加进result里,k参数实际未用
            subsets(nums, 0, len, len, result, list);
//        }

        return result;

    }

    private void subsets(int[] nums, int index, int len, int k, List<List<Integer>> result, List<Integer> list) {
        if (list.size() >= len) {
//            result.add(new ArrayList<Integer>(list));去掉for循环后注释掉
            return;
        }
        for (int j = index; j < len; j++) {
            list.add(nums[j]);
            result.add(new ArrayList<Integer>(list));
            subsets(nums, j + 1, len, k, result, list);
            list.remove(list.size() - 1);
        }

    }

    /*
    * BFS
    * */
    /*public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<Integer>());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            hashMap.put(nums[i], i);
        }
        int maxIndex = 0;
        List<List<Integer>> curResult = new LinkedList<>();
        curResult.add(new ArrayList<Integer>());
        for (int i = 0; i < len; i++) {
            int size = curResult.size();
            while (size-- > 0) {
                List<Integer> tmpList = curResult.remove(0);
                maxIndex = tmpList.size() == 0 ? -1 : hashMap.get(tmpList.get(tmpList.size() - 1));
                for (int j = maxIndex + 1; j < len; j++) {
                    List<Integer> tmp = new ArrayList<>(tmpList);
                    tmp.add(nums[j]);
                    curResult.add(tmp);
                    result.add(tmp);
                }

            }
        }
        return result;
    }*/


    /*
    * BFS2
    * */
   /* public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        result.add(new ArrayList<Integer>(list));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            hashMap.put(nums[i], i);
        }
        int index = 0;
        while (index < len || list.size() != 0) {
            if (index >= len || list.size() == len) {
                index = hashMap.get(list.get(list.size() - 1))+1;
                list.remove(list.size() - 1);
            }else{
                list.add(nums[index]);
                result.add(new ArrayList<Integer>(list));
                index++;
            }
        }

        return result;
    }*/

    /*
    * 对BFS的改进，对于C(n,k)，要用两个list是因为result中不能存在小于k的list，而此时不需要
    * */

  /*  public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

//        Arrays.sort(S);
        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }*/
}
