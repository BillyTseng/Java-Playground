package come.class18_Probability_Sampling.attempt03;

import java.util.Random;

public class PerfectShuffle {
    public void shuffle(int[] array) {
        int k = array.length;
        Random rand = new Random();
        for (int i = 0; i < k - 1; i++) {
            int j = rand.nextInt(k - i) + i;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
