package come.eClass2_LinkedList_BinarySearch.attempt02;

/**
 * 278. First Bad Version - easy
 */

public class Q2_1_FirstBadVersion {
    // pseudo method
    private boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }
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

        return (isBadVersion(left)) ? left : right;
    }
}
