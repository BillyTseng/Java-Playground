package come.class09_StringII.attempt02;

public class ReverseString {
    public String reverseI(String input) {
        int i = 0;
        int j = input.length() - 1;
        char[] chars = input.toCharArray();
        while (i < j) {
            swap(chars, i++, j--);
        }
        return new String(chars);
    }
    public String reverseII(String input) {
        char[] chars = input.toCharArray();
        helper(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void helper(char[] chars, int i, int j) {
        if (i >= j) {
            return;
        }
        swap(chars, i , j);
        helper(chars, i + 1, j - 1);
    }
    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
