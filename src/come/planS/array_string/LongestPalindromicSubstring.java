package come.planS.array_string;

public class LongestPalindromicSubstring {

    // Time: O(n^3), space: O(1)
    public String longestPalindrome(String input) {
        if (input.length() <= 1) {
            return input;
        }
        int start= 0, maxLen = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                if (isPalindrome(input, i, j) && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return new String(input.toCharArray(), start, maxLen);
    }

    private boolean isPalindrome(String input, int start, int end) {
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Time: O(n^2), space: O(1)
    public String longestPalindromeI(String input) {
        if (input.length() <= 1) {
            return input;
        }
        int start = 0, maxLen = 0;
        for (int i = 0; i < input.length(); i++) {
            int lenOdd = expandFromCenter(input, i, i);
            int lenEven = expandFromCenter(input, i, i + 1);
            int currMaxLen = Math.max(lenOdd, lenEven);

            if (currMaxLen > maxLen) {
                maxLen = currMaxLen;
                start = i - (currMaxLen - 1) / 2;
            }
        }
        return new String(input.toCharArray(), start, maxLen);
    }

    private int expandFromCenter(String input, int i, int j) {
        while (i >= 0 && j < input.length() && input.charAt(i) == input.charAt(j)) {
            i--;
            j++;
        }
        return (j - 1) - (i + 1) + 1;
    }
}
