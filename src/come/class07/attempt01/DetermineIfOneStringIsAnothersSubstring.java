package come.class07.attempt01;

public class DetermineIfOneStringIsAnothersSubstring {
    public int strstr(String large, String small) {
        if (large == null || small == null) {
            return -1;
        }

        if (small.length() == 0) {
            return 0;
        }

        if (large.length() == 0) {
            return -1;
        }

        if (large.length() < small.length()) {
            return -1;
        }

        for (int i = 0; i <= large.length() - small.length(); i++) {
            int j = 0;
            for (; j < small.length(); j++) {
                if (large.charAt(i + j) != small.charAt(j)) {
                    break;
                }
            }
            if (j == small.length()) {
                return i;
            }
        }
        return -1;
    }
}
