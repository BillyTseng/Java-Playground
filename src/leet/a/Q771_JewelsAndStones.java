package leet.a;

import java.util.HashSet;
import java.util.Set;

public class Q771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }

        Set<Character> jewelSet = buildJewelSet(J);
        int cnt = 0;
        for (char c : S.toCharArray()) {
            if (jewelSet.contains(c)) {
                cnt++;
            }
        }
        return cnt;
    }

    private Set<Character> buildJewelSet(String input) {
        Set<Character> jewelSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            jewelSet.add(c);
        }
        return jewelSet;
    }
}
