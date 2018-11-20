package leet.Q51toQ100;

import java.util.ArrayList;
import java.util.List;

public class Q57_InsertInterval {
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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int idx = 0;
        while (idx < intervals.size() && intervals.get(idx).start < newInterval.start) {
            idx++;
        }
        intervals.add(idx, newInterval);

        List<Interval> res = new ArrayList<>();
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
