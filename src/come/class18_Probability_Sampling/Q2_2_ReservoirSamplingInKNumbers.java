package come.class18_Probability_Sampling;

import java.util.ArrayList;
import java.util.List;

public class Q2_2_ReservoirSamplingInKNumbers {
    public class Solution {
        private final int k;
        private List<Integer> sample;
        private int count;

        public Solution(int k) {
            if (k <= 1) {
                throw new IllegalArgumentException("k must be > 0");
            }
            this.k = k;
            sample = new ArrayList<>();
            this.count = 0;
        }

        public void read(int value) {
            count++;
            if (count <= k) {
                sample.add(value);
            } else {
                int prob = (int)(Math.random() * count);
                if (prob < k) {
                    sample.set(prob, value);
                }
            }
        }

        public List<Integer> sample() {
            return sample;
        }
    }
}
