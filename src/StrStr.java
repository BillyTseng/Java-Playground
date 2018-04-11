/**
 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 * If target does not exist in source, just return -1.
 */


public class StrStr {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }

            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}
