package come.eClass3_TwoPointers_SlidingWindow.attempt02;

public class Q1_1_QuickSort {
    public int[] quickSort(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        }

        quickSort(input, 0, input.length - 1);
        return input;
    }

    private void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotPos = partition(input, left, right);
        quickSort(input, left, pivotPos - 1);
        quickSort(input, pivotPos + 1, right);
    }

    private int partition(int[] input, int left, int right) {
        int pivotPos = left + (int)(Math.random() * (right - left + 1));
        int pivot = input[pivotPos];
        swap(input, pivotPos, right);
        int l = left, r = right - 1;
        while (l <= r) {
            if (input[l] < pivot) {
                l++;
            } else if (input[r] >= pivot) {
                r--;
            } else {
                swap(input, l++, r--);
            }
        }
        swap(input, l, right);
        return l;
    }

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
