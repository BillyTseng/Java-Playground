package come.class10.attempt01;

public class StringAbbreviationMatching {
    public boolean match(String text, String pattern) {
        return match(text, 0, pattern, 0);
    }

    private boolean match(String text, int textStart, String pattern, int patternStart) {
        if (text.length() == textStart && pattern.length() == patternStart) {
            return true;
        } else if (text.length() <= textStart || pattern.length() <= patternStart) {
            return false;
        }

        if (Character.isLetter(pattern.charAt(patternStart))) {
            if (text.charAt(textStart) == pattern.charAt(patternStart))  {
                return match(text, textStart + 1, pattern, patternStart + 1);
            } else {
                return false;
            }
        } else {
            int num = 0;
            while (patternStart < pattern.length() && Character.isDigit(pattern.charAt(patternStart))) {
                num = num * 10 + (pattern.charAt(patternStart) - '0');
                patternStart++;
            }
            return match(text, textStart + num, pattern, patternStart);
        }
    }
}
