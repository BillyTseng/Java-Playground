package leet.g;

public class Q832_FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }

        for (int[] nums : A) {
            reverse(nums);
            invert(nums);
        }

        return A;
    }

    private void reverse(int[] input) {
        int left = 0, right = input.length - 1;
        while (left <= right) {
            swap(input, left++, right--);
        }
    }

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    private void invert(int[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] ^= 1;
        }
    }
}
