package come.class02;

public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        if (array == null) {
            return 0;
        }

        int[] dp = new int[array.length + 1];
        dp[0] = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int anArray : array) {
            int index = binarySearch(dp, anArray);
            dp[index] = anArray;
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return 0;
    }

    private int binarySearch(int[] dp, int num) {
        int left = 0, right = dp.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (dp[mid] < num) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
