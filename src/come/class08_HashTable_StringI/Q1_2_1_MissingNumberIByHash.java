package come.class08_HashTable_StringI;

import java.util.HashSet;

public class Q1_2_1_MissingNumberIByHash {
    public int missing(int[] array) {
        if (array == null) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }
        for (int i = 1; i <= array.length + 1; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
