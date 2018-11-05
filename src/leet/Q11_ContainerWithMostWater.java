package leet;

public class Q11_ContainerWithMostWater {
    // Brute force, time O(n^2), space O(1)
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int lowerEdge = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, lowerEdge * (j - i));
            }
        }
        return maxArea;
    }

    // two pointer, time O(n), space O(1)
    public int maxAreaI(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            int lowerEdge = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, lowerEdge * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
