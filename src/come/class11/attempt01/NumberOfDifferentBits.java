package come.class11.attempt01;

public class NumberOfDifferentBits {
    private int diffBits(int a, int b) {
        int xor = a ^ b;
        int cnt = 0;
        while (xor != 0) {
            cnt += xor & 1;
            xor >>>= 1;
        }
        return cnt;
    }
    public static void main(String[] args) {
        NumberOfDifferentBits solution = new NumberOfDifferentBits();
        System.out.println(solution.diffBits(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
