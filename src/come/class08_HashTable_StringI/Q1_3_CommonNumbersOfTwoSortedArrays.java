package come.class08_HashTable_StringI;

import java.util.ArrayList;
import java.util.List;

public class Q1_3_CommonNumbersOfTwoSortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> res = new ArrayList<>();
        if (A == null || B == null) {
            return res;
        }
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i).equals(B.get(j))) {
                res.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
