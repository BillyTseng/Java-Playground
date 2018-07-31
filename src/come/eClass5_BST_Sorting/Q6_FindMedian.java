package come.eClass5_BST_Sorting;

public class Q6_FindMedian {
    public int findMedian(int[] input) {
        int n = input.length;
        int k = n / 2 + 1;

        int p = quickSelect(input, 0, n - 1, k);
        return input[p];
    }

    // return the index of the kth smallest number
    private int quickSelect(int[] input, int left, int right, int k) {
        int pivot = input[right];
        int i = left, j = right;
        while (i <= j) {
            if (input[i] < pivot) {
                i++;
            } else if (pivot <= input[j]) {
                j--;
            } else {
                swap(input, i++, j--);
            }
        }
        swap(input, i, right);

        int m = i - left + 1;
        if (m == k) {
            return i;
        } else if (m > k) {
            return quickSelect(input, left, i - 1, k);
        } else {
            return quickSelect(input,i + 1, right, k - m);
        }
    }

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
