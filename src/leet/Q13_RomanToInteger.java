package leet;

import java.util.HashMap;
import java.util.Map;

public class Q13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = buildMap();
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Integer currValue = map.get(s.charAt(i));
            if (i == s.length() - 1) {
                sum += currValue;
            } else {
                if (currValue < map.get(s.charAt(i + 1))) {
                    sum -= currValue;
                } else {
                    sum += currValue;
                }
            }
        }
        return sum;
    }

    private Map<Character, Integer> buildMap() {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
