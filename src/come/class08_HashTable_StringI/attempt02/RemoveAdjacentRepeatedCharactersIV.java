package come.class08_HashTable_StringI.attempt02;

public class RemoveAdjacentRepeatedCharactersIV {
    public String deDup(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        char[] chars = input.toCharArray();
        int read = 1, write = 0;
        while (read < chars.length) {
            if (write == -1 || chars[read] != chars[write]) {
                chars[++write] = chars[read++];
            } else {
                write--;
                while (read + 1 < chars.length && chars[read] == chars[read + 1]) {
                    read++;
                }
                read++;
            }
        }
        return new String(chars, 0, write + 1);
    }
}
