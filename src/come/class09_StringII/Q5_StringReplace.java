package come.class09_StringII;

import java.util.ArrayList;
import java.util.List;

public class Q5_StringReplace {
    private String replaceI(String inputStr, String s, String t) {
        char[] input = inputStr.toCharArray();
        if (s.length() >= t.length()) {
            return replaceShorter(input, s, t);
        }
        return replaceLonger(input, s, t);
    }

    private String replaceShorter(char[] array, String pattern, String replacement) {
        int slow = 0, fast = 0;
        while (fast < array.length) {
            if (fast <= array.length - pattern.length() && equalString(array, pattern, fast)) {
                copyString(array, replacement, slow);
                slow += replacement.length();
                fast += pattern.length();
            } else {
                array[slow++] = array[fast++];
            }
        }
        return new String(array, 0, slow);
    }

    private String replaceLonger(char[] array, String pattern, String replacement) {
        List<Integer> matches = getAllMatches(array, pattern);
        int diff = replacement.length() - pattern.length();
        char[] res = new char[array.length + diff * matches.size()];
        int matchesIdx = matches.size() - 1;
        int slow = res.length - 1;
        int fast = array.length - 1;
        while (fast >= 0 ) {
            if (matchesIdx >= 0 && fast == matches.get(matchesIdx)) {
                slow -= replacement.length();
                copyString(res, replacement, slow + 1);
                fast -= pattern.length();
                matchesIdx--;
            } else {
                res[slow--] = array[fast--];
            }
        }
        return new String(res);
    }

    private List<Integer> getAllMatches(char[] array, String pattern) {
        List<Integer> matches = new ArrayList<>();
        int i = 0;
        while (i <= array.length - pattern.length()) {
            if (equalString(array, pattern, i)) {
                matches.add(i + pattern.length() - 1);
                i += pattern.length();
            } else {
                i++;
            }
        }
        return matches;
    }

    private boolean equalString(char[] array, String pattern, int fast) {
        int idx = 0;
        while (idx < pattern.length()) {
            if (array[fast++] != pattern.charAt(idx++)) {
                return false;
            }
        }
        return true;
    }

    private void copyString(char[] array, String replacement, int slow) {
        for (int i = 0; i < replacement.length(); i++) {
            array[slow + i] = replacement.charAt(i);
        }
    }

    public String replaceII(String input, String s, String t) {
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);
        StringBuilder sb = new StringBuilder();
        while (matchIndex != -1) {
            sb.append(input, fromIndex, matchIndex).append(t);
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        Q5_StringReplace solution = new Q5_StringReplace();
        System.out.println(solution.replaceI("aaa", "a", "bb"));
    }
}
