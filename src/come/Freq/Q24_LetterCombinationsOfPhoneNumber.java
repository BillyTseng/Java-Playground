package come.Freq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number - medium
 */

public class Q24_LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Integer, String> dict = buildDictMap();
        dfsHelper(digits, 0, new StringBuilder(), dict, res);
        return res;
    }

    private void dfsHelper(String digits, int idx, StringBuilder sb, Map<Integer, String> dict, List<String> res) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int cur = digits.charAt(idx) - '0';
        String words = dict.get(cur);
        for (char ch : words.toCharArray()) {
            sb.append(ch);
            dfsHelper(digits, idx + 1, sb, dict, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private Map<Integer, String> buildDictMap() {
        Map<Integer, String> dict = new HashMap<>();

        dict.put(0, "");
        dict.put(1, "");
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");
        return dict;
    }
}
