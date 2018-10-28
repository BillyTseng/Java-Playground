package come.planMV.strings;

/* https://leetcode.com/problems/valid-palindrome/ easy */
public class ValidPalindrome {
    public boolean valid(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0, j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i++) != input.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
