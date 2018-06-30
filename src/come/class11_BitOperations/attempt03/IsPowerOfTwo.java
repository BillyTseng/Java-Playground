package come.class11_BitOperations.attempt03;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }
}
