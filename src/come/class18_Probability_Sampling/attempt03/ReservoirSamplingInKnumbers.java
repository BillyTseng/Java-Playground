package come.class18_Probability_Sampling.attempt03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReservoirSamplingInKnumbers {
    class Solution {
        private List<Integer> sample;
        private int cnt;
        private final int K;

        public Solution(int k) {
            sample = new ArrayList<>();
            cnt = 0;
            this.K = k;
        }

        public void read(int value) {
            cnt++;
            if (cnt <= K) {
                sample.add(value);
            } else {
                int rand = new Random().nextInt(cnt);
                if (rand < K) {
                    sample.set(rand, value);
                }
            }
        }

        public List<Integer> sample() {
            return sample;
        }
    }
}



