package come.class18_Probability_Sampling.attempt02;

import java.util.Random;

public class Random7UsingRandom5 {
    public int random7() {
        while (true) {
            int prob = RandomFive.random5() * 5 + RandomFive.random5();
            if (prob < 21) {
                return prob % 7;
            }
        }
    }
}

class RandomFive {
    static int random5() {
        return new Random().nextInt(5);
    }
}
