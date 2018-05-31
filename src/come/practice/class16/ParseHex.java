package come.practice.class16;

public class ParseHex {
    public int parseHex(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a';
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A';
        }
        return Integer.MAX_VALUE;
    }
}
