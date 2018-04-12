package lint.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhoneNumber {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // write your code here
        String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        dfs(0, digits.length(), "", nums, digits);
        return ans;
    }

    private void dfs(int idx, int length, String str, String[] nums, String digits) {
        if (idx >= length) {
            ans.add(str);
            return;
        }
        int d = digits.charAt(idx) - '0';
        for (char c : nums[d].toCharArray()) {
            dfs(idx + 1, length, str + c, nums, digits);
        }
    }
}
