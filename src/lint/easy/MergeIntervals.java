package lint.easy;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> res = new ArrayList<>();
        intervals.sort(Comparator.comparing(i -> i.start));
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

    public static void main (String[] args) {
        /*
        [                     [
          (1, 3),               (1, 6),
          (2, 6),      =>       (8, 10),
          (8, 10),              (15, 18)
          (15, 18)            ]
        ]
        */
        List<Interval> input = new ArrayList<>();
        MergeIntervals test = new MergeIntervals();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(8, 10));
        input.add(new Interval(15, 18));
        List<Interval> output = test.merge(input);
        for (Interval item : output) {
            System.out.println(item.start + ", " + item.end);
        }
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
