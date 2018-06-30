package come.class21_RecursionII.attempt02;

public class StringAbbreviationMatching {
    public boolean match(String text, String pattern) {
        return match(text, 0, pattern, 0);
    }

    private boolean match(String text, int textStart, String pattern, int patternStart) {
        if (textStart == text.length() && patternStart == pattern.length()) {
            return true;
        } else if (textStart >= text.length() || patternStart >= pattern.length()) {
            return false;
        }

        if (Character.isLetter(pattern.charAt(patternStart))) {
            if (text.charAt(textStart) == pattern.charAt(patternStart)) {
                return match(text, textStart + 1, pattern, patternStart + 1);
            } else {
                return false;
            }
        } else {
            int num = 0;
            while (patternStart < pattern.length() && Character.isDigit(pattern.charAt(patternStart))) {
                num = num * 10 + (int)(pattern.charAt(patternStart) - '0');
                patternStart++;
            }
            return match(text, textStart + num, pattern, patternStart);
        }
    }
}
