package come.class18_Probability_Sampling;

public class Q3_b_Random1000UsingRandom5 {
    private int random1000() {
        // Write your solution here.
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        while (true) {
            int random = 0;
            for (int i = 0; i < 5; i++) {
                random = random * 5 + RandomFive.random5();
            }

            if (random < 3000) {
                return random % 1000;
            }
        }
    }

    public static void main(String[] args) {
        Q3_b_Random1000UsingRandom5 solution = new Q3_b_Random1000UsingRandom5();
        for (int i = 0; i < 10; i++) {
            System.out.print(solution.random1000() + " ");
        }
    }
}
