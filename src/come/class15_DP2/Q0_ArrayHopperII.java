package come.class15_DP2;

public class Q0_ArrayHopperII {
    public int minJump(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        int[] steps = new int[array.length];
        steps[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            final int UNREACHABLE = -1;
            if (array[i] == 0) {
                steps[i] = UNREACHABLE;
            } else if (i + array[i] >= array.length - 1) {
                steps[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = i + 1; j < array.length; j++) {
                    // next element is useless because it can not reach to the end.
                    if (steps[j] == UNREACHABLE) {
                        continue;
                    }
                    if (j <= i + array[i]) {
                        min = Math.min(min, steps[j]);
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    steps[i] = UNREACHABLE;
                } else {
                    steps[i] = 1 + min;
                }
            }
        }
        return steps[0];
    }

    public static void main(String[] args) {
        Q0_ArrayHopperII solution = new Q0_ArrayHopperII();
        System.out.println(solution.minJump(new int[]{2, 2, 1, 1, 4}));
        System.out.println(solution.minJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.minJump(new int[]{3, 3, 1, 0, 4}));
        System.out.println(solution.minJump(new int[]{2, 1, 1, 0, 2}));
    }
}
