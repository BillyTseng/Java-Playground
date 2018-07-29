package come.eClass5_BST_Sorting;

/**
 *  https://leetcode.com/problems/h-index/description/
 *
 *  Example: [3,0,6,1,5] h-index is 3
 *  Sorted -> [0, 1, 3, 5, 6]
 *  max(min(0, 5), min(1, 4), min(3, 3), min(5, 2), min(6, 1)) = 3
 */

public class Q9_HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        // build the buckets to contain counts, the index is the citations of paper.
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                buckets[n] += 1;
            } else {
                buckets[citations[i]] += 1;
            }
        }

        int hIndex = 0;
        int totalCount = 0;

        /**
         * the for loop enumerate
         * min(0, 5), min(1, 4), min(3, 3), min(5, 2), and min(6, 1), then the max value is the h-Index.
         *                ^  ^
         *       citation 1; there are 4 papers with greater than 1 citations.
         */
        for (int i = 0; i < buckets.length; i++) {
            hIndex = Math.max(hIndex, Math.min(i, n - totalCount));
            totalCount += buckets[i];
        }
        return hIndex;
    }
}
