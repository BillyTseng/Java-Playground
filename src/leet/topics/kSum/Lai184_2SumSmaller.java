package leet.topics.kSum;

import java.util.Arrays;

public class Lai184_2SumSmaller {
    public int smallerPairs(int[] array, int target) {
        int cnt = 0;
        Arrays.sort(array);
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] < target) {
                cnt += (j - i);
                i++;
            } else {
                j--;
            }
        }
        return cnt;
    }
}
