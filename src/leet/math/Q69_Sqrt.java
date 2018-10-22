package leet.math;

public class Q69_Sqrt {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;

        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (right * right == x) {
            return (int) right;
        }
        return (int) left;
    }
}
