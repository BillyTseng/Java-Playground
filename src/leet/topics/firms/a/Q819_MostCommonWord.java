package leet.topics.firms.a;

import java.util.*;

public class Q819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null) {
            return null;
        }
        // key: string, value: frequnecy
        Map<String, Integer> freqMap = new HashMap<>();
        String[] strs = paragraph.split("[!?',;. ]+");
        for (String str : strs) {
            String targetStr = str.toLowerCase();
            freqMap.put(targetStr, freqMap.getOrDefault(targetStr, 0) + 1);
        }

        Set<String> bannedSet = new HashSet<>();
        for (String str : banned) {
            bannedSet.add(str);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(new MyComparator());
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (!bannedSet.contains(entry.getKey())) {
                maxHeap.offer(entry);
            }
        }
        return maxHeap.poll().getKey();
    }

    private class MyComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            if (e1.getValue().equals(e2.getValue())) {
                return 0;
            }
            return e1.getValue() < e2.getValue() ? 1 : -1;
        }
    }
}
