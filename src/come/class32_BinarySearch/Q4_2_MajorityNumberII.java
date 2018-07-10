package come.class32_BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class Q4_2_MajorityNumberII {
    public List<Integer> majority(int[] array) {
        List<Integer> res = new ArrayList<>();
        if (array.length == 0) {
            return res;
        }
        int cand0 = 0;
        int count0 = 0;
        int cand1 = 0;
        int count1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                cand0 = array[0];
                count0 = 1;
            } else if (i == 1) {
                cand1 = array[1];
                count1 = 1;
            } else if (cand0 == array[i]) {
                count0++;
            } else if (cand1 == array[i]) {
                count1++;
            } else if (count0 == 0) {
                cand0 = array[i];
                count0 = 1;
            } else if (count1 == 0) {
                cand1 = array[i];
                count1 = 1;
            } else {
                count0--;
                count1--;
            }
        }
        count0 = 0;
        count1 = 0;
        for (int num : array) {
            if (cand0 == num) {
                count0++;
            } else if (cand1 == num) {
                count1++;
            }
        }
        if ((3 * count0) > array.length || (3 * count1) > array.length) {
            if (count0 > count1) {
                res.add(cand0);
            } else if (count0 < count1) {
                res.add(cand1);
            } else {
                if (cand0 < cand1) {
                    res.add(cand0);
                    res.add(cand1);
                } else {
                    res.add(cand1);
                    res.add(cand0);
                }
            }
        }
        return res;
    }
}
