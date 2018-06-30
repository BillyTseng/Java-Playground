package come.class18_Probability_Sampling.attempt02;

import java.util.Random;

public class ReservoirSampling {
}

class Solution {
    private Integer sample;
    private int cnt;
    public Solution() {
        sample = null;
        cnt = 0;
    }

    public void read(int value) {
        cnt++;
        int random = new Random().nextInt(cnt);
        if (random == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}
