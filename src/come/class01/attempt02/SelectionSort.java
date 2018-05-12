package come.class01.attempt02;

public class SelectionSort {
    public int[] solve(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            swap(array, i, minIdx);
        }
        return array;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
