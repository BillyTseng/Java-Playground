package leet.topics.firms.a.freq;

import java.util.Comparator;
import java.util.LinkedList;
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
        LinkedList<Interval> res = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }

        intervals.sort(new MyComparator());

        for (Interval item : intervals) {
            if (res.isEmpty() || res.getLast().end < item.start) {
                res.add(item);
            } else {
                res.getLast().end = Math.max(item.end, res.getLast().end);
            }
        }
        return res;
    }

    private class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start == i2.start) {
                return 0;
            }
            return i1.start < i2.start ? -1 : 1;
        }
    }
}
