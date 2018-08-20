package come.Freq;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 496. Next Greater Element I - easy
 */

public class Q15_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peekFirst()) {
                stack.pollFirst();
            }
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peekFirst());
            }
            stack.offerFirst(nums2[i]);
        }

        for (int j = 0; j < res.length; j++) {
            res[j] = map.get(nums1[j]);
        }
        return res;
    }
}
