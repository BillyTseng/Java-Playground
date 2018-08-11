package come.eClass10_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval - hard
 */
public class Q1_2_InsertInterval {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int idx = 0;
        while (idx < intervals.size() && intervals.get(idx).start < newInterval.start) {
            idx++;
        }
        intervals.add(idx, newInterval);

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(interval.end, end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args) {
        /**
         * input 1: [[1,2],[3,5],[6,7],[8,10],[12,16]]
         * input 2: [4,8]
         */
        int[][] input1 = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
        List<Interval> intervals = new ArrayList<>();
        for (int[] anArray : input1) {
            intervals.add(new Interval(anArray[0], anArray[1]));
        }
        Q1_2_InsertInterval solution = new Q1_2_InsertInterval();
        solution.insert(intervals, new Interval(4, 8));
    }
}
