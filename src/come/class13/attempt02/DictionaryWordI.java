package come.class13.attempt02;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        int n = input.length();
        Set<String> dictSet = buildSet(dict);
        boolean[] canBreak = new boolean[n + 1];

        for (int i = 1; i < canBreak.length; i++) {
            if (dictSet.contains(input.substring(0, i))) {
                canBreak[i] = true;
                continue;
            }

            for (int j = 1; j < i ; j++) {
                if (canBreak[j] && dictSet.contains(input.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[n];
    }

    private Set<String> buildSet(String[] dict) {
        Set<String> dictSet = new HashSet<>();
        for (String str : dict) {
            dictSet.add(str);
        }
        return dictSet;
    }
}
