package lint.medium;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length < 1) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int item : num) {
            set.add(item);
        }

        int length = 0;
        for (int aNum : num) {
            int down = aNum - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }

            int up = aNum + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }

            /* 2 3 4, up=5, down=1. So the size is 5-1-1=3*/
            length = Math.max(length, up - down - 1);
        }
        return length;
    }
}
