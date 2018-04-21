package come.class01;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length <= 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = new Random().nextInt(right - left + 1) + left;
        // swap pivot with the last element
        swap(array, pivot, right);
        pivot = right;
        int leftIdx = left, rightIdx = pivot - 1;
        while (leftIdx <= rightIdx) {
            if (array[leftIdx] < array[pivot]) {
                leftIdx++;
            } else if (array[rightIdx] >= array[pivot]) {
                rightIdx--;
            } else {
                swap(array, leftIdx++, rightIdx--);
            }
        }
        swap(array, pivot, leftIdx);
        pivot = leftIdx;
        return pivot;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();

        int[] array1 = null;
        solution.quickSort(array1);
        System.out.println(Arrays.toString(array1));

        array1 = new int[0];
        solution.quickSort(array1);
        System.out.println(Arrays.toString(array1));

        array1 = new int[] {5, 4, 3, 2, 1, 0};
        solution.quickSort(array1);
        System.out.println(Arrays.toString(array1));

        array1 = new int[] {5, -4, 3, -2, -1, 0};
        solution.quickSort(array1);
        System.out.println(Arrays.toString(array1));

        array1 = new int[] {5, -4, 3, -2, -1, 0, 3, 1, -4};
        solution.quickSort(array1);
        System.out.println(Arrays.toString(array1));
    }
}
