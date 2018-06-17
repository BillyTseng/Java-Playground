package come.class16.attempt02;

import java.util.Random;

public class PerfectShuffle {
    public void shuffle(int[] input) {
        if (input == null || input.length <= 1) {
            return;
        }

        Random random = new Random();
        int k = input.length;
        for (int i = 0; i < k; i++) {
            int j = random.nextInt(k - i) + i;
            swap(input, i, j);
        }
    }

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
