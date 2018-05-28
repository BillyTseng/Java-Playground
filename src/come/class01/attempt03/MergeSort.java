package come.class01.attempt03;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int i = left;
        int j = mid + 1;
        int idx = left;
        while (i <= mid && j <= right) {
            if (helper[j] < helper[i]) {
                array[idx++] = helper[j++];
            } else {
                array[idx++] = helper[i++];
            }
        }

        while (i <= mid) {
            array[idx++] = helper[i++];
        }
    }
}
