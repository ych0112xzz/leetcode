package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/9/12.
 */
public class Permutations {

    public static void main(String[] args) {

    }


    /*
    * DFS
    * */
    /*public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length==0){
            return null;
        }
        combination(nums,list,result);
        return result;
    }

    public static void  combination(int[] nums,ArrayList<Integer> list,List<List<Integer>> result){
        if(list.size()<nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (!list.contains(nums[i])){
                    list.add(nums[i]);
                    combination(nums, list, result);
                    System.out.println(list);
                    list.remove(list.size() - 1);
                }

            }
        }else{
            result.add(new ArrayList<Integer>(list));
           // list.remove(list.size() - 1);
           // list = new ArrayList<>();
        }
    }*/

   /*
   *  BFS
   * */
   /*public static List<List<Integer>> permute(int[] nums) {
       LinkedList<LinkedList<Integer>> deque = new LinkedList<>();
       deque.offer(new LinkedList<Integer>());
       for(int i=0;i<nums.length;i++) {
           int size = deque.size();
           while (size-- > 0) {//当前size也可以用i表示
               LinkedList<Integer> list = deque.poll();
               for(int j=0;j<nums.length;j++) {
                   if (!list.contains(nums[j])) {
                       LinkedList<Integer> tmp=new LinkedList<>(list);
                       tmp.add(nums[j]);
                       deque.offer(tmp);
                   }
               }
           }
       }
       return (List)deque;
   }*/

    /*
    *第二个BFS，对于调换后的for，如{1,2,3}：    [1] [1,2][2,1]  [3,1,2][1,3,2][1,2,3][3,2,1][2,3,1][2,1,3]
    * */
   /* public List<List<Integer>> permute(int[] nums) {
        LinkedList<ArrayList<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<Integer>());
        for(int i=0;i<nums.length;i++){
            int n=result.size();
            for(int j=0;j<n;j++) {
                List<Integer> list = result.poll();
                for (int k = 0; k <= list.size(); k++) {
                    ArrayList<Integer> cur = new ArrayList<>(list);
                    cur.add(k, nums[i]);
                    result.offer(cur);
                }
            }
        }
        return (List)result;
    }

    }*/

    /*
    * 第二个DFS
    * */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0) {
            return permutations;
        }
        permute(nums, 0, new LinkedList<Integer>(), permutations);
        return permutations;
    }

    private void permute(int[] nums, int start, List<Integer> permutation, List<List<Integer>>  permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }
        for(int i=0;i<=permutation.size();i++) {
            List<Integer> tmp = new LinkedList<>(permutation);
            tmp.add(i, nums[start]);
            permute(nums,start+1,tmp,permutations);
        }
    }

}
