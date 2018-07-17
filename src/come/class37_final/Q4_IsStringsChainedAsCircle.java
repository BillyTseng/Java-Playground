package come.class37_final;

public class Q4_IsStringsChainedAsCircle {
    public boolean isChain(String[] words) {
        if (words == null || words.length == 0) {
            return false;
        }

        return dfs(words, 1);
    }

    private boolean dfs(String[] words, int idx) {
        if (idx == words.length) {
            return canChain(words[0], words[idx - 1]);
        }

        for (int i = idx; i < words.length; i++) {
            if (canChain(words[i], words[idx - 1])) {
                swap(words, i, idx);
                if (dfs(words, idx + 1)){
                    return true;
                }
                swap(words, i, idx);
            }
        }
        return false;
    }

    private boolean canChain(String nextStr, String priorStr) {
        return (priorStr.charAt(priorStr.length() - 1) == nextStr.charAt(0));
    }

    private void swap(String[] words, int a, int b) {
        String temp = words[a];
        words[a] = words[b];
        words[b] = temp;
    }
}
