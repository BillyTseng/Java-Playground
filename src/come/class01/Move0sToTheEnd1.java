package come.class01;

public class Move0sToTheEnd1 {
    public int[] moveZero(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 0) {
            return array;
        }
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
