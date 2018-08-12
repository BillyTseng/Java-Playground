package come.eClass10_Intervals;

import java.util.Arrays;

public class Q5_MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length < 2) {
            return 0;
        }
        int m = intervals.length;
        int[] starts = new int[m];
        int[] ends = new int[m];
        for (int i = 0; i < m; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endIdx = 0;
        for (int i = 0; i < m; i++) {
            if (starts[i] < ends[endIdx]) {
                rooms++;
            } else {
                endIdx++;
            }
        }
        return rooms;
    }
}
