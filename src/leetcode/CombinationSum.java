package leetcode;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by ych0112xzz on 2016/12/26.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {1, 3, 6, 2};
        int target = 12;
        List<List<Integer>> dp = combinationSum(candidates, target);
        for(int i=0;i<dp.size();i++) {
            String result = "";
            //Collections.sort(dp.get(i));
            for(int j=0;j<dp.get(i).size();j++) {
                result += dp.get(i).get(j)+" ";
            }
            System.out.println(result.trim());
        }
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }


    /*
    * DFS1
    * */
   /* public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int len = candidates.length;
        combinationSum(candidates, 0, target, result, list);
        return result;
    }

    private void combinationSum(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            list.add(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], result, list);
            list.remove(list.size() - 1);
        }
    }*/

    /*
    * DFS
    * */
   /*    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // Arrays.sort(candidates);
        int len = candidates.length;
        combinationSum(candidates, 0, target, result, list);
        return result;
    }

    private void combinationSum(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        for(int i=start;i<candidates.length;i++) {
            list.add(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], result, list);
            list.remove(list.size() - 1);
        }
    }
*/

    /*
    * BFS+DP
    * */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>[] dp =new ArrayList[target+1] ;
        for(int i=1;i<=target;i++) {
            List<List<Integer>> result = new ArrayList<>();
            for(int j=0;j<candidates.length&&candidates[j]<=i;j++) {
                if (candidates[j] == i) {
                    result.add(Arrays.asList(candidates[j]));
                }else{
                    for (List<Integer> list : dp[i - candidates[j]]) {
                        if (candidates[j] <= list.get(0)) {//用来排除重复组合如[2,2,3],[2,3,2]
                            List<Integer> cur = new ArrayList<>();
                            cur.add(candidates[j]);
                            cur.addAll(list);
                            result.add(cur);
                        }
                    }
                }
            }
            dp[i] = result;
        }
        return dp[target];
    }


    /*
    * BFS2
    * */
    /*public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int i=0, size = candidates.length, sum=0;
        Stack<Integer> combi = new Stack<>(), indices = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        while (i < size) {
            if (sum + candidates[i]>= target) {
                if (sum + candidates[i] == target) {
                    combi.push(candidates[i]);
                    result.add(new ArrayList<>(combi));
                    combi.pop();
                }
                // indices stack and combination stack should have the same size all the time
                if (!indices.empty()){
                    sum -= combi.pop();
                    i = indices.pop();
                    while (i == size-1 && !indices.empty()) {
                        i = indices.pop();
                        sum -= combi.pop();

                    }
                }
                i++;
            } else {
                combi.push(candidates[i]);
                sum +=candidates[i];
                indices.push(i);
            }
        }
        return result;
    }*/
}
