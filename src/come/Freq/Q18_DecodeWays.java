package come.Freq;

import java.util.Arrays;

/**
 * 91. Decode Ways - medium
 */

public class Q18_DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] m = new int[s.length() + 1];
        Arrays.fill(m, -1);
        return numDecodings(s.toCharArray(), 0, m);
    }

    private int numDecodings(char[] array, int level, int[] m) {
        if (m[level] != -1) {
            return m[level];
        }
        if (level == array.length) {
            m[level] = 1;
            return 1;
        }
        int ways = 0;
        if (array[level] != '0') {
            ways += numDecodings(array, level + 1, m);
        }

        if (validCode(array, level)) {
            ways += numDecodings(array, level + 2, m);
        }
        m[level] = ways;
        return ways;
    }

    private boolean validCode(char[] array, int start) {
        if (start + 1 >= array.length) {
            return false;
        }
        char digit1 = array[start];
        char digit2 = array[start + 1];
        if (digit1 == '1') {
            return true;
        }

        if (digit1 == '2' && (digit2 - '0') <= 6) {
            return true;
        }

        return false;
    }
}
