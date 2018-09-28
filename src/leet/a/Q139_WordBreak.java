package leet.a;

import java.util.List;

public class Q139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;

        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }
}
