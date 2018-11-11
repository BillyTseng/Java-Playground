package leet.topics.firms.g;

public class Q681_NextClosestTime {
    public String nextClosestTime(String time) {
        int[] digits = new int[]{
                time.charAt(0) - '0', time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
        int h = digits[0] * 10 + digits[1];
        int m = digits[2] * 10 + digits[3];
        int now = toTime(h, m);
        int[] best = new int[]{now};
        int[] currDigits = new int[]{0, 0, 0, 0};
        dfs(digits, currDigits, 0, now, best);

        return String.format("%02d:%02d", best[0] / 60, best[0] % 60);
    }

    private void dfs(int[] digits, int[] currDigits, int idx, int now, int[] best) {
        if (idx == 4) {
            int currH = currDigits[0] * 10 + currDigits[1];
            int currM = currDigits[2] * 10 + currDigits[3];
            if (currH > 23 || currM > 59) {
                return;
            }
            int currTime = toTime(currH, currM);
            if (timeDiff(currTime, now) < timeDiff(best[0], now)) {
                best[0] = currTime;
            }
            return;
        }

        for (int digit : digits) {
            currDigits[idx] = digit;
            dfs(digits, currDigits, idx + 1, now, best);
        }
    }

    private int toTime(int h, int m) {
        return h * 60 + m;
    }

    private int timeDiff(int one, int two) {
        if (one == two) {
            return Integer.MAX_VALUE;
        }
        return ((one - two) + 24 * 60) % (24 * 60);
    }
}
