package come.class18_Probability_Sampling.attempt03;

import java.util.List;

public class Percentile95 {
    public int percentile95(List<Integer> lengths) {
        int[] cnt = new int[4097];
        for (int i : lengths) {
            cnt[i]++;
        }

        int sum = 0;
        int i = 0;
        for (; i < cnt.length; i++) {
            sum += cnt[i];
            if (sum >= lengths.size() * 0.95) {
                break;
            }
        }
        return i;
    }

}
