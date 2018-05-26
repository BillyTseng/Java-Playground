package come.class07.attempt02;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo == null || combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> freqMap = getFreqMap(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new myComparator());
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }

        }
        String[] res = new String[minHeap.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String str : combo) {
            Integer value = freqMap.get(str);
            if (value == null) {
                freqMap.put(str, 1);
            } else {
                freqMap.put(str, value + 1);
            }
        }
        return freqMap;
    }

    private class myComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
            return entry1.getValue().compareTo(entry2.getValue());
        }
    }
}
