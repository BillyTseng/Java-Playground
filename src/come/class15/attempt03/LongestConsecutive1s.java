package come.class15.attempt03;

public class LongestConsecutive1s {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int max = array[0];
        int prevSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1) {
                prevSum += 1;
            } else {
                prevSum = 0;
            }
            max = Math.max(max, prevSum);
        }
        return max;
    }
}
