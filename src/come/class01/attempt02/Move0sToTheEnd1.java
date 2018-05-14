package come.class01.attempt02;

public class Move0sToTheEnd1 {
    public int[] moveZero(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int i = 0, j = array.length - 1;
        while (i <= j) {
            if (array[i] != 0) {
                i++;
            } else if (array[j] == 0) {
                j--;
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
