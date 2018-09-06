package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2_1_AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> res = new ArrayList<>();
        if (l.length() <= 0) {
            return res;
        }

        if (l.length() < s.length()) {
            return res;
        }

        Map<Character, Integer> freqmap = buildMap(s);
        int lenCnt = 0;
        for (int i = 0; i < l.length(); i++) {
            char ch = l.charAt(i);
            Integer freq = freqmap.get(ch);
            if (freq != null) {
                freqmap.put(ch, --freq);
                if (freq == 0) {
                    lenCnt++;
                }
            }

            if (i >= s.length()) {
                char leftChar = l.charAt(i - s.length());
                Integer leftFreq = freqmap.get(leftChar);
                if (leftFreq != null) {
                    freqmap.put(leftChar, ++leftFreq);
                    if (leftFreq == 1) {
                        lenCnt--;
                    }
                }
            }
            if (lenCnt == freqmap.size()) {
                res.add(i - s.length() + 1);
            }
        }
        return res;
    }

    private Map<Character, Integer> buildMap(String str) {
        Map<Character, Integer> res = new HashMap<>();
        for (char ch : str.toCharArray()) {
            res.put(ch, res.getOrDefault(ch, 0) + 1);
        }
        return res;
    }
}
