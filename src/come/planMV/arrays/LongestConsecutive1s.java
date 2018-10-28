package come.planMV.arrays;

public class LongestConsecutive1s {
    public int longest(int[] array) {
        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                len += 1;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 0;
            }
        }

        return maxLen;
    }
}
