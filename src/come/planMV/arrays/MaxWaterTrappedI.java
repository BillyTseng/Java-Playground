package come.planMV.arrays;

/* https://leetcode.com/problems/trapping-rain-water/ hard*/
public class MaxWaterTrappedI {
    public int maxTrapped(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }

        int left = 0;
        int right = height.length - 1;
        int lMax = height[left];
        int rMax = height[right];

        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if (lMax < rMax) {
                result += (lMax - height[left++]);
            } else {
                result += (rMax - height[right--]);
            }
        }
        return result;
    }
}
