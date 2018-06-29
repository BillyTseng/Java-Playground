package come.class09_StringII.attempt02;

public class ReverseWordsInASentenceI {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] chars = input.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (chars[read] != ' ' && (read == 0 || chars[read - 1] == ' ')) {
                write = read;
            }
            if (chars[read] != ' ' && (read == chars.length - 1 || chars[read + 1] == ' ')) {
                reverse(chars, write, read);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
