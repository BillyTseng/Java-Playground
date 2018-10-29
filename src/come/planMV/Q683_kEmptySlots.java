package come.planMV;

import java.util.TreeSet;

public class Q683_kEmptySlots {
    // time: O(nlogn), space: O(n)
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> ts = new TreeSet<>();

        int day = 0;
        for (int flowerLoc : flowers) {
            day++;
            ts.add(flowerLoc);
            Integer lower = ts.lower(flowerLoc);
            Integer higher = ts.higher(flowerLoc);

            if (lower != null && flowerLoc - lower - 1 == k ||
                    higher != null && higher - flowerLoc - 1 == k) {
                return day;
            }
        }
        return -1;
    }
}
