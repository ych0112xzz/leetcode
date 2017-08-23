package leetcode;

import java.util.*;

/**
 * Created by ych0112xzz on 2017/4/20.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start!=o2.start) {
                    return o1.start - o2.start;
                }else{
                    return o1.end - o2.end;
                }
            }
        });
        List<Interval> res = new ArrayList<>();
        if (intervals.size() <= 1) {
            return intervals;
        }

        Iterator itr = intervals.iterator();
        Interval prev = (Interval) itr.next();
        Interval next=null;
        boolean isMerge = false;
        while (itr.hasNext()) {
            next= (Interval) itr.next();
            Interval tmp = new Interval();
            if (prev.end >= next.start) {
                tmp.start=prev.start;
                tmp.end =Math.max(prev.end,next.end);
                prev = tmp;
                isMerge = true;
            }else{
                res.add(prev);
                prev = next;
                isMerge = false;
            }
        }
        if (!isMerge) {
            res.add(next);
        }else {
            res.add(prev);
        }
        return res;
    }

}
