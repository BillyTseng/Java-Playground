package come.class09_StringII.attempt02;

public class ReOrderArray {
    public int[] reorder(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        if (array.length % 2 == 0) {
            convert(array, 0, array.length - 1);
        } else {
            convert(array, 0, array.length - 2);
        }
        return array;
    }
    private void convert(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size <= 2) {
            return;
        }
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);

        convert(array, left, left + (leftMid - left) * 2 - 1);
        convert(array, left + (leftMid - left) * 2, right);
    }

    private void reverse(int[] array, int i, int j) {
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
