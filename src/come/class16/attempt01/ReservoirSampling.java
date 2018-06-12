package come.class16.attempt01;

public class ReservoirSampling {
    public class Solution {
        private Integer sample;
        private int count;
        public Solution() {
            this.sample = null;
            this.count = 0;
        }

        public void read(int value) {
            count++;
            int prob = (int)(Math.random() * count);
            if (prob == 0) {
                sample = value;
            }
        }

        public Integer sample() {
            return sample;
        }
    }
}
