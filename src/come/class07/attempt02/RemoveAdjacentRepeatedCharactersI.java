package come.class07.attempt02;

public class RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        char[] chars = input.toCharArray();
        int read = 0, write = 0;
        while (read < chars.length) {
            if (read == 0 || chars[read] != chars[read - 1]) {
                chars[write++] = chars[read++];
            } else {
                read++;
            }
        }
        return new String(chars, 0, write);
    }
}
