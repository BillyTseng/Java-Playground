package come.class24_twoPointer_LCA.attempt01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2_2_LargestAndSecondLargest {
    class Element {
        int value;
        List<Integer> beat;

        Element(int value) {
            this.value = value;
            beat = new ArrayList<>();
        }
    }

    public int[] largestAndSecond(int[] array) {
        Element[] input = convert(array);
        int n = array.length;
        while (n > 1) {
            compareAndSwap(input , n);
            n = (n + 1) / 2;
        }

        return new int[] {input[0]. value, getMax(input[0].beat)};
    }

    private int getMax(List<Integer> input) {
        int max = input.get(0);
        for (int item : input) {
            max = Math.max(max, item);
        }
        return max;
    }

    private Element[] convert(int[] array) {
        Element[] res = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = new Element(array[i]);
        }
        return res;
    }

    private void swap(Element[] input, int a, int b) {
        Element temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    private void compareAndSwap(Element[] input, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (input[i].value < input[n - 1 - i].value) {
                swap(input, i, n - 1 - i);
            }
            input[i].beat.add(input[n - 1 - i].value);
        }
    }

    public static void main(String[] args) {
        Q2_2_LargestAndSecondLargest solution = new Q2_2_LargestAndSecondLargest();
        System.out.println(Arrays.toString(solution.largestAndSecond(new int[] {6, 4, 2, 1, 5, 3})));
    }
}
