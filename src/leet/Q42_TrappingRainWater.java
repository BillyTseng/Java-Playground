package leet;

public class Q42_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int lMax = height[left];
        int rMax = height[right];
        int res = 0;
        while (left < right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            if (lMax < rMax) {
                res += (lMax - height[left++]);
            } else {
                res += (rMax - height[right--]);
            }
        }
        return res;
    }
}
