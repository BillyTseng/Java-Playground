package leet.Q01to50;

public class Q28_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int p1 = i;
            int p2 = 0;
            while (p2 < needle.length() && haystack.charAt(p1) == needle.charAt(p2)) {
                p1++;
                p2++;
            }
            if (p2 == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
