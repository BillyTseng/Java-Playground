package come.eClass8_DP;

public class Q4_1_LongestPalindromicSubstring {
    private int start = 0, max = 0;
    public String longestPalindrome(String input) {
        if (input.length() <= 1) {
            return input;
        }

        for (int i = 0; i < input.length(); i++) {
            expandFromCenter(input, i, i);
            expandFromCenter(input, i, i + 1);
        }
        return input.substring(start, start + max);
    }

    private void expandFromCenter(String input, int left, int right) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        if ((right - 1) - (left + 1) + 1 > max) {
            start = left + 1;
            max = right - left - 1;
        }
    }
}
