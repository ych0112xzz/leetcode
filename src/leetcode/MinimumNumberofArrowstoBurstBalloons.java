package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ych0112xzz on 2016/11/24.
 */
public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length<=1){
            return points.length;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int count = 1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=end){
                end = Math.min(end, points[i][1]);
            }else{
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
