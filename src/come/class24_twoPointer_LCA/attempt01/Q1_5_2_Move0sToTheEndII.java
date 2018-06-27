package come.class24_twoPointer_LCA.attempt01;

public class Q1_5_2_Move0sToTheEndII {
    public int[] moveZero(int[] array) {
        if (array.length <= 1) {
            return array;
        }
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
