package come.class16.attempt01;

import java.util.List;

public class Percentile95 {
    public int percentile95(List<Integer> lengths) {
        int[] count = new int[4097];
        for (int len : lengths) {
            count[len]++;
        }
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
            if (sum >= lengths.size() * 0.95) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
