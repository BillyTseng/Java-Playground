package lint.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class InsertInterval {
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        if (newInterval == null) {
            return intervals;
        }
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        intervals.add(newInterval);
        intervals.sort(Comparator.comparing(i -> i.start));

        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for (Interval curr : intervals) {
            if (prev == null || prev.end < curr.start) {
                res.add(curr);
                prev = curr;
            } else {
                prev.end = Math.max(prev.end, curr.end);
            }
        }

        return res;
    }
}
