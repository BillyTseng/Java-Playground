package leet.topics.firms.g;

public class Q482_LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch == '-') {
                continue;
            }
            ch = Character.toUpperCase(ch);
            sb.append(ch);

            if (++count % K == 0) {
                sb.append('-');
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
