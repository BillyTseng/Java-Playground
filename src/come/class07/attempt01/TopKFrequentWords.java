package come.class07.attempt01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo == null || combo.length == 0) {
            return new String[0];
        }

        Map<String, Integer> map = getFreqMap(combo);

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(new myComparator());
        for (Map.Entry<String, Integer> ele : map.entrySet()) {
            maxHeap.offer(ele);
        }

        int loopLength = Math.min(k, maxHeap.size());
        String[] res = new String[loopLength];
        for (int i = 0; i < loopLength; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : combo) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        return map;
    }

    private class myComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            if (e1.getValue().equals(e2.getValue())) {
                return 0;
            }
            return e1.getValue() > e2.getValue() ? -1 : 1;
        }
    }
}
