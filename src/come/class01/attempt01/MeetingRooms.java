package come.class01.attempt01;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        // Write your solution here
        int m = intervals.length;
        int n = intervals[0].length;
        if (intervals == null || m <= 1 || n < 2) {
            return true;
        }

        // Lambda function
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Regular comparator
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int currEnd = intervals[0][1];
        for (int i = 1; i < m; i++) {
            if (intervals[i][0] <= currEnd) {
                return false;
            }
            currEnd = intervals[i][1];
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms solution = new MeetingRooms();
        int[][] arr1 = new int[][] {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(solution.canAttendMeetings(arr1));

        arr1 = new int[][] {{0, 30}, {31, 100}, {150, 200}};
        System.out.println(solution.canAttendMeetings(arr1));
    }
}
