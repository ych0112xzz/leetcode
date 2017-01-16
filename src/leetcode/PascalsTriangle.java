package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ych0112xzz on 2016/10/10.
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        if(numRows==0){
            return result;
        }

        prev.add(1);
        result.add(prev);
        if(numRows==1){

            return result;
        }
        for(int i=1;i<numRows;i++){
            prev = result.get(i - 1);
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for(int j=1;j<i;j++) {
                cur.add(prev.get(j-1)+prev.get(j));
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }
}
