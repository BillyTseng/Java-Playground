package come.laicode.dp;

public class LongestPalindromicSubstring {
    // brute force, time O(n^3), space O(1)
    public String longestPalindrome(String input) {
        if (input.length() <= 1) {
            return input;
        }
        int max = 0;
        int ansStart = 0;

        for (int end = 1; end < input.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (isPalindrome(input, start, end)) {
                    if (end - start + 1 > max) {
                        max = end - start + 1;
                        ansStart = start;
                    }
                }
            }
        }
        return new String(input.toCharArray(), ansStart, max);
    }

    private boolean isPalindrome(String input, int start, int end) {
        while (start < end) {
            if (input.charAt(start++) != input.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    //DP, time O(n^2), space O(n^2)
    public String longestPalindromeI(String input) {
        int n = input.length();
        if (n <= 1) {
            return input;
        }
        int ansEnd = 0, ansStart = 0;
        boolean[][] isPalin = new boolean[n][n];
        for (int end = 0; end < input.length(); end++) {
            for (int start = 0; start <= end; start++) {
                if (start == end) {
                    isPalin[start][end] = true;
                    continue;
                }
                if (input.charAt(start) == input.charAt(end)) {
                    isPalin[start][end] = end - start < 2 || isPalin[start + 1][end - 1];
                }
                if (isPalin[start][end]) {
                    if (end - start > ansEnd - ansStart) {
                        ansEnd = end;
                        ansStart = start;
                    }
                }
            }
        }
        return new String(input.toCharArray(), ansStart, ansEnd - ansStart + 1);
    }

    // Expand Around Center, time O(n^2), space O(1)
    public String longestPalindromeII(String input) {
        if (input.length() <= 1) {
            return input;
        }
        int start = 0, max = 0;
        for (int i = 0; i < input.length(); i++) {
            int lenOdd = expandAroundCenter(input, i, i);
            int lenEven = expandAroundCenter(input, i, i + 1);
            int len = Math.max(lenOdd, lenEven);
            if (len > max) {
                start = i - (len - 1) / 2;
                max = len;
            }
        }
        return new String(input.toCharArray(), start, max);
    }

    private int expandAroundCenter(String input, int left, int right) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
