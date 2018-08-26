package come.Freq;

/**
 *  161. One Edit Distance - medium
 */

public class Q29_OneEditDistance {
    public boolean oneEditDistance(String source, String target) {
        if (source == null && target == null) {
            return true;
        }
        if (source == null || target == null) {
            return false;
        }

        int m = source.length();
        int n = target.length();

        if (m == n) {
            return isChangeOneCharacter(source, target);
        } else if (m - n == 1) {
            return isAddOneCharacter(source, target);
        } else if (n - m == 1) {
            return isAddOneCharacter(target, source);
        }
        return false;
    }

    private boolean isChangeOneCharacter(String s, String t) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean isAddOneCharacter(String longStr, String shortStr) {
        boolean flag = false;
        int longIdx = 0;
        for (int shortIdx = 0; shortIdx < shortStr.length(); shortIdx++) {
            if (longStr.charAt(longIdx) != shortStr.charAt(shortIdx)) {
                if (flag) {
                    return false;
                }
                flag = true;
                shortIdx--;
            }
            longIdx++;
        }
        return true;
    }
}
