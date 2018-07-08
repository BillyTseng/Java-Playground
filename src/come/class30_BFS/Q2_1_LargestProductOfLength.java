package come.class30_BFS;

import java.util.HashMap;
import java.util.Map;

public class Q2_1_LargestProductOfLength {
    public int largestProduct(String[] dict) {
        Map<String, Integer> bitMasks = buildBitMasks(dict);

        int largest = 0;
        for (int j = 1; j < dict.length; j++) {
            for (int i = 0; i < j; i++) {
                int product = dict[i].length() * dict[j].length();
                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);
                if ((iMask & jMask) == 0) {
                    largest = Math.max(largest, product);
                }
            }
        }
        return largest;
    }

    private Map<String, Integer> buildBitMasks(String[] dict) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : dict) {
            int bitMask = 0;
            for (int i = 0; i < str.length(); i++) {
                bitMask |= 1 << (str.charAt(i) - 'a');
            }
            map.put(str, bitMask);
        }
        return map;
    }
}
