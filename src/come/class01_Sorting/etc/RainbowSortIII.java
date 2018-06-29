package come.class01_Sorting.etc;

import java.util.Arrays;

public class RainbowSortIII {
    public int[] rainbowSortIII(int[] array, int k) {
        // Write your solution here
        if (array == null || array.length <= 0) {
            return array;
        }
        if (k <= 0) {
            return array;
        }
        rainbowSortIII(array, 0, array.length - 1, 1, k);
        return array;
    }

    private void rainbowSortIII(int[] colors, int left, int right, int colorFrom, int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }
        if (left >= right) {
            return;
        }

        int l = left, r= right;
        int colorMid = colorFrom + (colorTo - colorFrom) / 2;
        while (l <= r) {
            while (l <= r && colors[l] <= colorMid) {
                l++;
            }
            while (l <= r && colors[r] > colorMid) {
                r--;
            }
            if (l <= r) {
                swap(colors, l++, r--);
            }
        }
        rainbowSortIII(colors, left, r, colorFrom, colorMid);
        rainbowSortIII(colors, l, right, colorMid + 1, colorTo);
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        RainbowSortIII solution = new RainbowSortIII();
        int[] array1 = null;
        System.out.println(Arrays.toString(solution.rainbowSortIII(array1, 0)));
        array1 = new int[0];
        System.out.println(Arrays.toString(solution.rainbowSortIII(array1, 0)));
        array1 = new int[] {1, 3, 4, 2, 5, 2, 1};
        System.out.println(Arrays.toString(solution.rainbowSortIII(array1, 5)));
    }
}
