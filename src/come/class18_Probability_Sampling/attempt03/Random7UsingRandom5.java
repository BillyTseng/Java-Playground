package come.class18_Probability_Sampling.attempt03;

import java.util.Random;

public class Random7UsingRandom5 {
    public int random7() {
        while (true) {
            int i = RandomFive.random5() * 5 + RandomFive.random5();
            if (i < 21) {
                return i % 7;
            }
        }
    }
}

class RandomFive {
    static int random5() {
        return new Random().nextInt(5);
    }
}
