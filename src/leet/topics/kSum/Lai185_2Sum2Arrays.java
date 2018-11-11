package leet.topics.kSum;

import java.util.HashSet;
import java.util.Set;

public class Lai185_2Sum2Arrays {
    public boolean existSum(int[] a, int[] b, int target) {
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        for (int num : b) {
            if (setA.contains(target - num)) {
                return true;
            }
        }
        return false;
    }
}
