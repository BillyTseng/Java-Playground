package come.eClass11_mock;

import java.util.Arrays;

/**
 * 362 - Design Hit Counter - medium
 */

public class Q2_DesignAFiveMinsCounter {
    class Counter {
        private static final int FIVE_MINS_TIME_GAP = 5 * 60;
        private int cacheSum;
        private long prevSecond;
        private int[] counter;

        Counter() {
            counter = new int[FIVE_MINS_TIME_GAP];
            cacheSum = 0;
            prevSecond = System.currentTimeMillis() / 1000;
        }

        public void hit() {
            long currentSecond = System.currentTimeMillis() / 1000;
            update(currentSecond);
            counter[(int)(currentSecond % FIVE_MINS_TIME_GAP)]++;
            cacheSum++;
            prevSecond = currentSecond;
        }

        public int getHits() {
            long currentSecond = System.currentTimeMillis() / 1000;
            update(currentSecond);
            prevSecond = currentSecond;
            return cacheSum;
        }

        private void update(long currentSecond) {
            if (currentSecond - prevSecond >= FIVE_MINS_TIME_GAP) {
                Arrays.fill(counter, 0);
                cacheSum = 0;
            } else {
                for (long t = prevSecond + 1; t <= currentSecond; t++) {
                    int idx = (int)(t % FIVE_MINS_TIME_GAP);
                    cacheSum -= counter[idx];
                    counter[idx] = 0;
                }
            }
        }
    }
}
