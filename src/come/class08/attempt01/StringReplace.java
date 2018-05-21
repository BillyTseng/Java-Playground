package come.class08.attempt01;

public class StringReplace {
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
}
