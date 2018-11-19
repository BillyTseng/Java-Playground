package leet.Q51toQ100;

import java.util.ArrayList;
import java.util.List;

public class Q56_MergeIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));


        for (Interval i : intervals) {
            if (res.isEmpty() || res.get(res.size() - 1).end < i.start) {
                res.add(i);
            } else {
                int end = res.get(res.size() - 1).end;
                res.get(res.size() - 1).end = Math.max(end, i.end);
            }
        }
        return res;
    }
}
