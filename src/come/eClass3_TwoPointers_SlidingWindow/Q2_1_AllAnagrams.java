package come.eClass3_TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2_1_AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> res = new ArrayList<>();
        if (l.length() == 0 || s.length() > l.length()) {
            return res;
        }

        Map<Character, Integer> countDownMap = buildCountDownMap(s);
        int match = 0;
        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = countDownMap.get(tmp);
            if (count != null) {
                countDownMap.put(tmp, --count);
                if (count == 0) {
                    match++;
                }
            }
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = countDownMap.get(tmp);
                if (count != null) {
                    countDownMap.put(tmp, ++count);
                    if (count == 1) {
                        match--;
                    }
                }
            }
            if (match == countDownMap.size()) {
                res.add(i - s.length() + 1);
            }
        }
        return res;
    }

    private Map<Character, Integer> buildCountDownMap(String input) {
        Map<Character, Integer> ans = new HashMap<>();
        for (char c : input.toCharArray()) {
            Integer count = ans.get(c);
            if (count == null) {
                ans.put(c, 1);
            } else {
                ans.put(c, count + 1);
            }
        }

        return ans;
    }
}
