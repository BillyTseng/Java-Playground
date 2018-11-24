package leet.Q51toQ100;

public class Q70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
