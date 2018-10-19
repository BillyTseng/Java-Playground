package come.seattlePlan.dp;

public class ClimbingStairs {
    public int stairs(int n) {
        if (n <= 2) {
            return n;
        }

        //int[] dp = new int[n + 1];
        //dp[1] = 1;
        //dp[2] = 2;
        int prevPrevWays = 1;
        int prevWays = 2;
        int currWays = 0;

        for (int i = 3; i <= n; i++) {
            //dp[i] = dp[i - 1] + dp[i - 2];
            currWays = prevPrevWays + prevWays;
            prevPrevWays = prevWays;
            prevWays = currWays;
        }
        //return dp[n];
        return currWays;
    }
}
