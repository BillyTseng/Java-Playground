package leet;

import java.util.ArrayList;
import java.util.List;

public class Q763_PartitionLabels {
    public List<Integer> partitionLabels(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return res;
        }

        int[] endMap = new int[26];
        for (int i = 0; i < input.length(); i++) {
            endMap[input.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < input.length(); i++) {
            end = Math.max(end, endMap[input.charAt(i) - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
