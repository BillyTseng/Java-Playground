package come.class11_BitOperations;

public class Q1_IsPowerOfTwo {
    public boolean isPowerOfTwoI(int number) {
        if (number <= 0) {
            return false;
        }
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>= 1;
        }
        return count == 1;
    }

    public boolean isPowerOfTwoII(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }
}
