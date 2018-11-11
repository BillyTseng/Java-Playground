package leet.topics.firms.a.freq;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253_MeetingRoomsII {
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

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        //Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        Arrays.sort(intervals, (Interval i1, Interval i2) -> {
            if (i1.start == i2.start) {
                return 0;
            }
            return i1.start < i2.start ? -1 : 1;
        });

        // save the end index in the min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0].end);
        int roomCnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            // prev meeting is not over, add 1 room.
            if (minHeap.peek() > intervals[i].start) {
                roomCnt++;
            } else {
                minHeap.poll();
            }
            minHeap.offer(intervals[i].end);
        }
        return roomCnt;
    }
}
