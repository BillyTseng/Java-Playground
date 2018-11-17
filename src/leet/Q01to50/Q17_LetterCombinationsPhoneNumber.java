package leet.Q01to50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17_LetterCombinationsPhoneNumber {
    private Map<Character, String> map;
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        buildMap();
        dfsHelper(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void dfsHelper(String digits, int idx, StringBuilder sb, List<String> res) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String characters = map.get(digits.charAt(idx));
        for (char ch : characters.toCharArray()) {
            sb.append(ch);
            dfsHelper(digits, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void buildMap() {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
