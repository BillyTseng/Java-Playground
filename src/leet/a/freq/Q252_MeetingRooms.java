package leet.a.freq;

import java.util.Arrays;
import java.util.Comparator;

public class Q252_MeetingRooms {
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

    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new MyComparator());
        Interval prev = null;

        for (Interval curr : intervals) {
            if (prev != null && prev.end > curr.start) {
                return false;
            }
            prev = curr;
        }
        return true;
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
