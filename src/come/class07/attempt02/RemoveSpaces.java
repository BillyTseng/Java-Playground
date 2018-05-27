package come.class07.attempt02;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] chars = input.toCharArray();
        int write = 0, read = 0;
        while (read < chars.length) {
            if (chars[read] == ' ' && (read == 0 || chars[read - 1] == ' ')) {
                read++;
            } else {
                chars[write++] = chars[read++];
            }
        }
        if (write > 0 && chars[write - 1] == ' ') {
            write--;
        }
        return new String(chars, 0, write);
    }
}
