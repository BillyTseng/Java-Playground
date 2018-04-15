package lint.medium;

// Fake class is not implemented.
 class SVNRepo {
     public static boolean isBadVersion(int k) {
         return false;
     }
 }

public class FirstBadVersion {
    /*
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int left = 1, right = n;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (SVNRepo.isBadVersion(left)) {
            return left;
        }
        return right;
    }
}
