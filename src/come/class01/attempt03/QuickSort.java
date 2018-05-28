package come.class01.attempt03;

public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIdx = left + (int)(Math.random() * (right - left + 1));
        int pivot = array[pivotIdx];
        swap(array, pivotIdx, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            } else if (pivot <= array[j]) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
