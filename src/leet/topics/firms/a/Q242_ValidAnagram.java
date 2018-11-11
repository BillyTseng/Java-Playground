package leet.topics.firms.a;

public class Q242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] srcDictMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            srcDictMap[s.charAt(i) - 'a']++;
            srcDictMap[t.charAt(i) - 'a']--;
        }

        for (int num : srcDictMap) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
