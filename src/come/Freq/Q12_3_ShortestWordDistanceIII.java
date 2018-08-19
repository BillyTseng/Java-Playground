package come.Freq;

/**
 * 245. Shortest Word Distance III - medium
 */

public class Q12_3_ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int idxSame = -1;
        int minLen = Integer.MAX_VALUE;
        boolean flagSameInputWord = word1.equals(word2);

        for (int i = 0; i < words.length; i++) {
            if (flagSameInputWord && words[i].equals(word1)) {
                if (idxSame != -1) {
                    minLen = Math.min(minLen, i - idxSame);
                }
                idxSame = i;
            } else if (words[i].equals(word1)) {
                if (idx2 != -1) {
                    minLen = Math.min(minLen, i - idx2);
                }
                idx1 = i;
            } else if (words[i].equals(word2)) {
                if (idx1 != -1) {
                    minLen = Math.min(minLen, i - idx1);
                }
                idx2 = i;
            }
        }
        return minLen;
    }
}
