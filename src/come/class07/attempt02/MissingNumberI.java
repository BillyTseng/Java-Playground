package come.class07.attempt02;

public class MissingNumberI {
    public int missing(int[] array) {
        if (array == null || array.length == 0) {
            return 1;
        }
        int xor = 0;
        for (int num : array) {
            xor ^= num;
        }

        for (int i = 1 ; i <= array.length + 1; i++) {
            xor ^= i;
        }
        return xor;
    }
}
