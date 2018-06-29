package come.class01_Sorting.etc;

import java.util.Arrays;

/* Red is denoted by 0, Green is denoted by 1,  Blue is denoted by 2 and Black is denoted by 3 */
public class RainbowSortII {
    public int[] rainbowSortII(int[] array) {
        // Write your solution here
        if (array == null || array.length <= 0) {
            return array;
        }
        rainbowSortII(array, 0, array.length - 1, 0, 3);
        return array;
    }

    private void rainbowSortII(int[] colors, int left, int right, int colorFrom, int colorTo) {
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
        rainbowSortII(colors, left, r, colorFrom, colorMid);
        rainbowSortII(colors, l, right, colorMid + 1, colorTo);
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        RainbowSortII solution = new RainbowSortII();
        int[] array1 = null;
        System.out.println(Arrays.toString(solution.rainbowSortII(array1)));
        array1 = new int[0];
        System.out.println(Arrays.toString(solution.rainbowSortII(array1)));
        array1 = new int[] {3, 3, 2, 1, 0, 2, 0};
        System.out.println(Arrays.toString(solution.rainbowSortII(array1)));
    }
}
