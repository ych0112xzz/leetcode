package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/11/7.
 */
public class Triangle {
    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(list);
        System.out.println(triangle);
        System.out.println(new Triangle().minimumTotal(triangle));
    }


    /*
    * 递归，TLE
    * */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        List<Integer> list=triangle.get(0);
        if(triangle.size()==1){
            return list.get(0);
        }
        return minimumTotal(triangle, 0,0);
    }

    public int minimumTotal(List<List<Integer>> triangle,int row,int column) {
        if(row<triangle.size()){
            int min=minimumTotal(triangle, row + 1, column);
            min=Math.min(min, minimumTotal(triangle, row + 1, column + 1)) + triangle.get(row).get(column);
            return min;
        }else{
            return 0;
        }

    }

    /*
    * 动态规划
    * */
    /*public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        for(int i=1;i<triangle.size();i++){
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);
            for(int j=1;j<cur.size()-1;j++){
                cur.set(j, Math.min(prev.get(j - 1), prev.get(j)) + cur.get(j));
            }
            cur.set(0, prev.get(0) + cur.get(0));
            cur.set(cur.size() - 1, prev.get(prev.size() - 1) + cur.get(cur.size() - 1));
        }
        List<Integer> list = triangle.get(triangle.size() - 1);
        int result = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i)<result){
                result = list.get(i);
            }
        }
        return result;
    }*/

    //Bottom-Up 6ms，实质与上面解法相同，但此方法可以修改为空间复杂度为O(1)
    /*public class Solution {
        public int minimumTotal1(List<List<Integer>> triangle) {
            int[] nums = new int[triangle.size()];
            for(int i = 0; i < triangle.size(); i++)
                nums[i] = triangle.get(triangle.size() - 1).get(i);
            for(int i = triangle.size() - 2; i >= 0; i--){
                for(int j = 0; j < triangle.get(i).size(); j++){
                    nums[j] = triangle.get(i).get(j) + Math.min(nums[j], nums[j + 1]);
                }
            }
            return nums[0];
        }
    }*/

    //Top-Down 4ms

       /* public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle.size() == 0) return 0;
            long[][] cache = new long[triangle.size()][triangle.size()];
            for(int i = 0; i < cache.length; i++)
                for(int j = 0; j < cache.length; j++)
                    cache[i][j] = Long.MIN_VALUE;
            return dfs(triangle, 0, 0, 0, cache);
        }

        private int dfs(List<List<Integer>> triangle, int iCur, int jCur, int total, long[][] cache){
            int min = Integer.MAX_VALUE;
            if(cache[iCur][jCur] != Long.MIN_VALUE){
                min = (int)cache[iCur][jCur];
            }
            else if(iCur == triangle.size() - 1){
                min = triangle.get(iCur).get(jCur);
            }else{
                min = dfs(triangle, iCur + 1, jCur, triangle.get(iCur).get(jCur), cache);
                min = Math.min(min, dfs(triangle, iCur + 1, jCur + 1, triangle.get(iCur).get(jCur), cache));
            }
            cache[iCur][jCur] = min;
            return min + total;
        }*/


}
