package come.eClass3_TwoPointers_SlidingWindow.attempt02;

public class Q1_3_Move0sToTheEndII {
    public int[] moveZero(int[] array) {
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                array[slow++] = array[fast];
            }
        }

        while (slow < array.length) {
            array[slow++] = 0;
        }

        return array;
    }
}
