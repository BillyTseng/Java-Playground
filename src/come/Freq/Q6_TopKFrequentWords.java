package come.Freq;

import java.util.*;

/**
 * 692. Top K Frequent Words - medium
 */

public class Q6_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> freqMap = buildFreqMap(words);
        PriorityQueue<Map.Entry<String, Integer>> minheap = new PriorityQueue<>(new MyComparator());

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minheap.offer(entry);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        int size = minheap.size();
        for (int i = 0; i < size; i++) {
            res.add(minheap.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }

    private class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            if (e1.getValue().equals(e2.getValue())) {
                // string compareTo is reverse order.
                return e2.getKey().compareTo(e1.getKey());
            }
            return e1.getValue().compareTo(e2.getValue());
        }
    }

    private Map<String, Integer> buildFreqMap(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        return freqMap;
    }
}
