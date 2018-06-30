package come.class15_DP2.attempt03;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        Set<String> dictSet = buildSet(dict);
        int n = input.length();
        boolean[] canBreak = new boolean[n + 1];
        canBreak[0] = true;
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (canBreak[j] && dictSet.contains(input.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[n];
    }

    private Set<String> buildSet(String[] dict) {
        Set<String> res = new HashSet<>();
        for (String str : dict) {
            res.add(str);
        }
        return res;
    }
}
