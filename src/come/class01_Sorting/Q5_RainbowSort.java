package come.class01_Sorting;

public class Q5_RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 0) {
            return array;
        }
        int neg = 0, zero = 0;
        int one = array.length - 1;
        while (zero <= one) {
            if (array[zero] == -1) {
                swap(array, neg++, zero++);
            } else if (array[zero] == 0) {
                zero++;
            } else {
                swap(array, zero, one--);
            }
        }
        return array;
    }
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
