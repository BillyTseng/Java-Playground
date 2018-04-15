package lint.medium;

public class MinimumWindowSubstring {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        if (source == null || source.length() == 0||
                target == null || target.length() == 0) {
            return "";
        }

        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];
        initTargetHash(targetHash, target);

        String minStr = "";
        int minLength = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (i = 0; i < source.length(); i++) {
            while (j < source.length() && !isValid(sourceHash, targetHash)) {
                sourceHash[source.charAt(j)]++;
                j++;
            }
            if (isValid(sourceHash, targetHash)) {
                if (j - i < minLength) {
                    minLength = j - i;
                    minStr = source.substring(i, j);
                }
            }
            sourceHash[source.charAt(i)]--;
        }
        return minStr;
    }

    private void initTargetHash(int[] targetHash, String target) {
        for (char c : target.toCharArray()) {
            targetHash[c]++;
        }
    }

    private boolean isValid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < 256; i++) {
            if (targetHash[i] > sourceHash[i]) {
                return false;
            }
        }
        return true;
    }
}
