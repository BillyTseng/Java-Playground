package come.class11_BitOperations;

class Q4_ReverseBits {
    int reverseBits(int x) {
        int i = 0;
        int j = 31;
        while (i < j) {
            x = reverseBitPair(x, i++, j--);
        }
        return x;
    }

    private int reverseBitPair(int x, int i, int j) {
        int leftBit = (x >>> i) & 1;
        int rightBit = (x >>> j) & 1;
        if (leftBit != rightBit) {
            x ^= ((1 << i) | (1 << j));
        }
        return x;
    }
}
