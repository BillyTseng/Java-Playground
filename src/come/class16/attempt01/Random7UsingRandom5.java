package come.class16.attempt01;

public class Random7UsingRandom5 {
    public int random7() {
        // write your solution here
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        while (true) {
            int num = RandomFive.random5() * 5 + RandomFive.random5();
            if (num < 21) {
                return num % 7;
            }
        }
    }
}

class RandomFive {
    static int random5() {
        return (int) (Math.random() * 5);
    }
}
