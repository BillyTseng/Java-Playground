package come.class24_twoPointer_LCA.attempt01;

public class Q1_5_1_Move0sToTheEndI {
    public int[] moveZero(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (array[j] == 0) {
                j--;
            } else if (array[i] != 0) {
                i++;
            } else {
                swap(array, i++, j--);
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
