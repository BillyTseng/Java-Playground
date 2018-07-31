package come.eClass5_BST_Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q8_TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        List<String>[] buckets = new List[combo.length + 1];
        Map<String, Integer> freqMap = new HashMap<>();
        for (String str : combo) {
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }

        for (String key : freqMap.keySet()) {
            int count = freqMap.get(key);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(key);
        }
        List<String> list = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && list.size() < k; i--) {
            if (buckets[i] != null) {
                list.addAll(buckets[i]);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
