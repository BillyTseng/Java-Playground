package come.class08.attempt01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    private List<Integer> allAnagrams(String s, String l) {
        List<Integer> res = new ArrayList<>();
        if (l.length() == 0 || s.length() > l.length()) {
            return res;
        }
        Map<Character, Integer> map = countMap(s);
        int matches = 0;
        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, --count);
                if (count == 0) {
                    matches++;
                }
            }
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, ++count);
                    if (count == 1) {
                        matches--;
                    }
                }
            }
            if (matches == map.size()) {
                res.add(i - s.length() + 1);
            }
        }
        return res;
    }

    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        AllAnagrams solution = new AllAnagrams();
        System.out.println(solution.allAnagrams("aa", "baaaa"));
    }
}
