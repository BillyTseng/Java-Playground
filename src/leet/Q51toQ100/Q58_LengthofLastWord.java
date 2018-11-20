package leet.Q51toQ100;

public class Q58_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean isAlphabet = false;
        int resLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
                isAlphabet = true;
                resLength++;
            } else {
                if (isAlphabet) {
                    return resLength;
                }
            }
        }
        return resLength;
    }
}
