package come.class11.attempt03;

public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        int xor = a ^ b;
        int cnt = 0;
        while (xor != 0) {
            cnt += xor & 1;
            xor >>>= 1;
        }
        return cnt;
    }
}
