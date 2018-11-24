package leet.Q51toQ100;

public class Q69_Sqrt_x {
    // time O(√x)
    public int mySqrt(int x) {
        long ans = 1;
        while (ans * ans <= x) {
            ans++;
        }
        if (ans * ans == x) {
            return (int)ans;
        }
        return (int)(ans - 1);
    }

    // time O(log x)
    public int mySqrtI(int x) {
        long left = 0;
        long right = x;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right * right == x) {
            return (int)right;
        }
        return (int)left;
    }
}
