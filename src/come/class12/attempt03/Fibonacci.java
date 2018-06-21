package come.class12.attempt03;

public class Fibonacci {
    public long fibonacci(int k) {
        if (k <= 0) {
            return 0;
        }
        long a = 0;
        long b = 1;

        for (int i = 1; i < k; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
