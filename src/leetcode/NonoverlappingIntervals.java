package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ych0112xzz on 2016/11/24.
 */
public class NonoverlappingIntervals {
    public static void main(String[] args){
        Interval[] intevals = {new Interval(1, 2)};
        System.out.println(new NonoverlappingIntervals().eraseOverlapIntervals(intevals));
    }
    int count = 0;
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        filter(intervals);

        return count;
    }

    private void filter(Interval[] intervals) {
        Interval firstInt = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= firstInt.end) {
                firstInt = intervals[i];
            }else{
                count++;
                if(intervals[i].start>=firstInt.start&&intervals[i].end<=firstInt.end){
                    firstInt = intervals[i];
                }
            }
        }
    }
}
