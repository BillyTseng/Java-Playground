package come.class16.attempt03;

import java.util.Random;

public class ReservoirSampling {
    class Solution {
        private Integer sample;
        private int cnt;
        public Solution() {
            sample = null;
            cnt = 0;
        }

        public void read(int value) {
            cnt++;
            Random rand = new Random();
            if (rand.nextInt(cnt) == 0) {
                sample = value;
            }
        }

        public Integer sample() {
            return sample;
        }
    }
}


