package leet.topics.firms.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q760_FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        // key: B's value, value: B's index(B's value could be repeated)
        Map<Integer, List<Integer>> bMap = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            List<Integer> indices = bMap.get(B[i]);
            if (indices == null) {
                bMap.put(B[i], new ArrayList<>());
            }
            bMap.get(B[i]).add(i);
        }

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            List<Integer> idxList = bMap.get(A[i]);
            res[i] = idxList.get(0);
            idxList.remove(0);
        }
        return res;
    }
}
