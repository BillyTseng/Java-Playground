package come.seattlePlan.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationsForTelephonePadI {
    Map<Character, String> digitMap = new HashMap<>();
    public String[] combinations(int number) {
        List<String> res = new ArrayList<>();
        fillDigitMap();

        combinations(String.valueOf(number), 0, new StringBuilder(), res);

        String[] resArr = new String[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private void combinations(String input, int idx, StringBuilder sb, List<String> res) {
        if (idx == input.length()) {
            res.add(sb.toString());
            return;
        }

        String currLetters = digitMap.get(input.charAt(idx));
        for (char ch : currLetters.toCharArray()) {
            sb.append(ch);
            combinations(input, idx + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void fillDigitMap() {
        digitMap.put('0', "");
        digitMap.put('1', "");
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
    }
}
