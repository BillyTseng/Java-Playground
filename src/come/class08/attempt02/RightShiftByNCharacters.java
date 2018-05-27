package come.class08.attempt02;

public class RightShiftByNCharacters {
    public String rightShift(String input, int n) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] chars = input.toCharArray();
        n %= chars.length;
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        if (i >= j) {
            return;
        }
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        reverse(chars, i + 1, j - 1);
    }
}
