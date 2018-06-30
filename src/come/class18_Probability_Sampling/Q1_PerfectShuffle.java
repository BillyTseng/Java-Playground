package come.class18_Probability_Sampling;

import java.util.Random;

public class Q1_PerfectShuffle {
    public void shuffle(int[] array) {
        if (array.length <= 1) {
            return;
        }
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            int j = r.nextInt(array.length - i) + i;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
