package come.eClass3_TwoPointers_SlidingWindow.attempt02;

public class Q1_1_2_Move0sToTheEndI {
    public int[] moveZero(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            if (array[left] == 0) {
                swap(array, left, right--);
            } else {
                left++;
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
