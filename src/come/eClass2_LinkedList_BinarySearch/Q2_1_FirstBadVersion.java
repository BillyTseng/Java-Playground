package come.eClass2_LinkedList_BinarySearch;

/**
 * https://leetcode.com/problems/first-bad-version/description/
 */

public class Q2_1_FirstBadVersion {
    // pseudo function.
    private boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isBadVersion(left) ? left : right;
    }
}
