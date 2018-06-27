package come.class24_twoPointer_LCA.attempt01;

public class Q2_1_LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        int n = array.length;
        for (int i = 0; i < n/2; i++) {
            if (array[i] > array[n - 1 - i]) {
                swap(array, i, n - 1 - i);
            }
        }
        int min = getMin(array, 0, (n - 1)/2);
        int max = getMax(array, n/2 , n - 1);
        return new int[] {max, min};
    }

    private int getMin(int[] array, int left, int right) {
        int min = array[left];
        for (int i = left + 1; i <= right; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

    private int getMax(int[] array, int left, int right) {
        int max = array[left];
        for (int i = left + 1; i <= right; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
