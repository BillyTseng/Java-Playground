package come.class11_BitOperations;

public class Q2_NumberOfDifferentBits {
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
        Q2_NumberOfDifferentBits solution = new Q2_NumberOfDifferentBits();
        System.out.println(solution.diffBits(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
