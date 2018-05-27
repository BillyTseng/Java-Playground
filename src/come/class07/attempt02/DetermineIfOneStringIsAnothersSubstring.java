package come.class07.attempt02;

public class DetermineIfOneStringIsAnothersSubstring {
    public int strstr(String large, String small) {
        if (large == null || small == null) {
            return -1;
        }

        if (large.length() < small.length()) {
            return -1;
        }

        if (small.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (equals(large, small, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean equals(String large, String small, int start) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(start + i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
