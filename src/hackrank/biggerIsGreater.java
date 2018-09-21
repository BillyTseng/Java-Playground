package hackrank;

// https://www.nayuki.io/page/next-lexicographical-permutation-algorithm

public class biggerIsGreater {
    private static boolean nextPermutation(char[] input) {
        // find the start idx of descending.
        int i = input.length - 1;
        while (i >= 1 && input[i - 1] >= input[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        // pivot is input[i - 1]
        // find the rightmost value which is bigger than pivot then swap.
        int j = input.length - 1;
        while (input[i - 1] >= input[j]) {
            j--;
        }
        swap(input, j, i - 1);

        // reverse the suffix
        j = input.length - 1;
        while (i < j) {
            swap(input, i++, j--);
        }
        return true;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
