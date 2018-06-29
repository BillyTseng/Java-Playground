package come.class06_Heap_GraphI_BFS;

import java.util.Arrays;

public class Q1_2_KSmallestInUnsortedArrayQuickSelect {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length <= 0 || k <= 0) {
            return new int[0];
        }

        quickSelect(array, 0 , array.length - 1, k - 1);
        int[] res = Arrays.copyOf(array, k);
        Arrays.sort(res);
        return res;
    }

    private void quickSelect(int[] array, int left, int right, int target) {
        int mid = partition(array, left, right);
        if (mid != target) {
            if (target < mid) {
                quickSelect(array, left, mid - 1, target);
            } else {
                quickSelect(array, mid + 1, right, target);
            }
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if (pivot < array[end]) {
                end--;
            } else {
                swap(array, start++, end--);
            }
        }
        swap(array, start, right);
        return start;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
