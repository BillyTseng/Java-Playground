package come.class09_StringII;

public class Q4_1_ReverseString {
    public String reverseIterative(String input) {
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        int i = 0, j = array.length - 1;
        while (i <= j) {
            swap(array, i++, j--);
        }
        return new String(array);
    }

    public String reverseRecursive(String input) {
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        helper(array, 0, array.length - 1);
        return new String(array);
    }

    private void helper(char[] array, int i, int j) {
        if (i >= j) {
            return;
        }
        swap(array, i, j);
        helper(array, ++i, --j);
    }

    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
