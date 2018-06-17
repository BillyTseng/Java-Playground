package come.class16.attempt02;

public class Random1000UsingRandom5 {
    public int random1000() {
        while (true) {
            int prob = 0;
            for (int i = 0; i < 5; i++) {
                prob = prob * 5 + RandomFive.random5();
            }
            if (prob < 3000) {
                return prob % 1000;
            }
        }
    }
}
