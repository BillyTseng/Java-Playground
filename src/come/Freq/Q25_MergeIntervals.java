package come.Freq;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Q25_MergeIntervals {
    class Interval {
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
        LinkedList<Interval> merged = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return merged;
        }
        intervals.sort(new MyComparator());
        for (Interval curr : intervals) {
            if (merged.isEmpty() || merged.getLast().end < curr.start) {
                merged.add(curr);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, curr.end);
            }
        }

        return merged;
    }

    private class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start == i2.start) {
                return 0;
            }
            return i1.start < i2.start ? -1 : 0;
        }
    }
}
