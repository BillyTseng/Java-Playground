package leet.topics.firms.a;

public class Q746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0;
        int b = 0;
        for (int num : cost) {
            int c = num + Math.min(a, b);
            a = b;
            b = c;
        }
        return Math.min(a, b);
    }
}
