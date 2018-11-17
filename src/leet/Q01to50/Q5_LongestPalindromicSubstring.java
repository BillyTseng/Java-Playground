package leet.Q01to50;

public class Q5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int maxLen = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int lenOdd = expandFromCenter(s, i, i);
            int lenEven = expandFromCenter(s, i, i + 1);
            int currMaxLen = Math.max(lenOdd, lenEven);

            if (currMaxLen > maxLen) {
                maxLen = currMaxLen;
                start = i - (maxLen - 1) / 2;
            }
        }
        return new String(s.toCharArray(), start, maxLen);
    }

    private int expandFromCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return (j - 1) - (i + 1) + 1;
    }
}
