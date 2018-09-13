package leet.a;

import java.util.ArrayList;
import java.util.List;

public class Q763_PartitionLabels {
    public List<Integer> partitionLabels(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null) {
            return res;
        }
        int[] dictMap = new int[26];
        for (int i = 0; i < input.length(); i++) {
            int charIdx = input.charAt(i) - 'a';
            dictMap[charIdx] = i;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < input.length(); i++) {
            int charIdx = input.charAt(i) - 'a';
            end = Math.max(end, dictMap[charIdx]);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
