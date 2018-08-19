package come.Freq;

/**
 * 243. Shortest Word Distance - easy
 */

public class Q12_1_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
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
