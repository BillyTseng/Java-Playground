package come.class16.attempt03;

public class Random1000UsingRandom5 {
    public int random1000() {
        while(true) {
            int rand = 0;
            for (int i = 0; i < 5; i++) {
                rand = rand * 5 + RandomFive.random5();
            }
            if (rand < 3000) {
                return rand % 1000;
            }
        }
    }
}
