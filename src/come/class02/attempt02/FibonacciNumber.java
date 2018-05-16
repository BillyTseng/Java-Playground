package come.class02.attempt02;

public class FibonacciNumber {
    public long fibonacci(int k) {
        if (k <= 0) {
            return 0;
        }
        long a = 0, b = 1, c = k;
        for (int i = 2; i <= k; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
