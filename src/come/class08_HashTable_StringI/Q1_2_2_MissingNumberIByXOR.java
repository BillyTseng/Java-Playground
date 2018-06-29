package come.class08_HashTable_StringI;

public class Q1_2_2_MissingNumberIByXOR {
    public int missing(int[] array) {
        if (array == null) {
            return -1;
        }
        int XOR = 0;
        for (int i = 1; i <= array.length + 1; i++) {
            XOR ^= i;
        }
        for (int num : array) {
            XOR ^= num;
        }
        return XOR;
    }
}
