package leet.string;

/* 859. Buddy Strings - easy */

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            int[] counts = new int[26];
            for (int i = 0; i < A.length(); i++) {
                counts[A.charAt(i) - 'a']++;
            }

            for (int cnt : counts) {
                if (cnt > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int[] indices = new int[] {-1, -1};
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (indices[0] == -1) {
                        indices[0] = i;
                    } else if (indices[1] == -1) {
                        indices[1] = i;
                    } else {
                        return false;
                    }
                }
            }
            return (indices[1] != -1 &&
                    A.charAt(indices[0]) == B.charAt(indices[1]) && A.charAt(indices[1]) == B.charAt(indices[0]));
        }
    }
}
