package come.class02_RecursionI_BinarySearch.attempt01;

public class Q1_1_FibonacciNumber {
    public long fibonacci(int K) {
        // Write your solution here
        if (K <= 0) {
            return 0;
        }
        if (K == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;
        long t = a + b;
        for (int i = 0; i < K - 2; i++) {
            a = b;
            b = t;
            t = a + b;
        }
        return t;
    }

    public static void main(String[] args) {
        Q1_1_FibonacciNumber solution = new Q1_1_FibonacciNumber();
        int K = 50;
        for (int i = 0; i <= K; i++) {
            System.out.print(solution.fibonacci(i) + " ");
        }
    }
}
