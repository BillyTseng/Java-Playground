package lint.easy;

public class ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            while(left < s.length() && !isAlphanumeric(s.charAt(left))) {
                left++;
            }
            // for empty string.
            if (left == s.length()) {
                return true;
            }
            while(right >= 0 && !isAlphanumeric(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left++)) !=
                    Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
