package come.planMV.strings;

import java.util.HashMap;
import java.util.Map;

public class Q290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] array = str.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            if (map.containsKey(p)) {
                if (!map.get(p).equals(array[i])) {
                    return false;
                }
            } else if (map.containsValue(array[i])) {
                return false;
            }
            map.put(p, array[i]);
        }
        return true;
    }
}
