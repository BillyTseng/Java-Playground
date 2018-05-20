package come.class08.attempt01;

public class RightShiftByNCharacters {
    public String rightShift(String input, int n) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        char[] array = input.toCharArray();
        n = n % array.length;
        reverse(array, 0, array.length - 1);
        reverse(array, 0, n - 1);
        reverse(array, n, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int i, int j) {
        while (i <= j) {
            swap(array, i++, j--);
        }
    }

    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
