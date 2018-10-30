package come.planMV;

public class Q681_nextClosestTime {
    public String nextClosestTime(String time) {
        int[] org = new int[] {time.charAt(0) - '0', time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
        int h = 10 * org[0] + org[1];
        int m = 10 * org[2] + org[3];
        int now = h * 60 + m;
        int[] digits = new int[] {0, 0, 0, 0};
        int[] best = new int[] {now};
        dfs(now, 0, digits, best, org);

        return String.format("%02d:%02d", best[0] / 60, best[0] % 60);
    }

    private void dfs(int now, int idx, int[] digits, int[] best, int[] org) {
        if (idx == 4) {
            int h = digits[0] * 10 + digits[1];
            int m = digits[2] * 10 + digits[3];
            if (h > 23 || m > 59) {
                return;
            }
            int curr = h * 60 + m;

            if (diffTime(curr, now) < diffTime(best[0], now)) {
                best[0] = curr;
            }
            return;
        }

        for (int digit : org) {
            digits[idx] = digit;
            dfs(now, idx + 1, digits, best, org);
        }
    }

    private int diffTime(int one, int two) {
        if (one == two) {
            return Integer.MAX_VALUE;
        }
        final int MINUTES_PER_DAY = 24 * 60;
        return ((one - two) + MINUTES_PER_DAY) % (MINUTES_PER_DAY);
    }
}
