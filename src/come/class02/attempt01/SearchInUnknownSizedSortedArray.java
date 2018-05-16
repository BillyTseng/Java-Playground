package come.class02.attempt01;

interface Dictionary {
    public Integer get(int index);
}

public class SearchInUnknownSizedSortedArray {
    public int search(Dictionary dict, int target) {
        // Write your solution here
        if (dict == null) {
            return -1;
        }

        int left = 0;
        int right = 1;
        while (dict.get(right) != null && dict.get(right) < target) {
            if (dict.get(right) == target) {
                return right;
            }
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || target < dict.get(mid)) {
                right = mid - 1;
            } else if (target > dict.get(mid)) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
