package come.class08.attempt01;
/*
* { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
* { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
* { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }
*/
public class ReOrderArray {
    public int[] reorder(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        if (array.length % 2 ==0) {
            convert(array, 0, array.length - 1);
        } else {
            convert(array, 0, array.length - 2);
        }
        return array;
    }

    private void convert(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length <= 2) {
            return;
        }

        int mid = left + length / 2;
        int leftMid = left + length / 4;
        int rightMid = left + length * 3 / 4;

        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);

        convert(array, left, left + 2 * (leftMid - left) - 1);
        convert(array, left + 2 * (leftMid - left), right);
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
