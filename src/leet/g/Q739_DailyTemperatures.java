package leet.g;

import java.util.Arrays;

public class Q739_DailyTemperatures {
    // naive, Time O(n^2), space O(1), Runtime: 221 ms
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    // next array, Time O(N * W), w is 100 - 30 = 71. So time is O(N), Space O(W), Runtime: 15 ms
    public int[] dailyTemperaturesI(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = size - 1; i >= 0; i--) {
            int warmIdx = Integer.MAX_VALUE;
            int curTemper = temperatures[i];
            for (int t = curTemper + 1; t <= 100; t++) {
                if (next[t] < warmIdx) {
                    warmIdx = next[t];
                }
            }
            if (warmIdx != Integer.MAX_VALUE) {
                res[i] = warmIdx - i;
            }
            next[temperatures[i]] = i;
        }
        return res;
    }
}
