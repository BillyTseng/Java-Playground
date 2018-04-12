package lint.easy;

public class SqrtX {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x <= 1) {
            return x;
        }

        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
