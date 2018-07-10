package come.class32_BinarySearch;

public class Q4_1_MajorityNumberI {
    public int majority(int[] array) {
        int candidate = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                count++;
                candidate = array[i];
            } else if (array[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
