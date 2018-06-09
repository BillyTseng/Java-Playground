package come.class13.attempt02;

public class ArrayHopperII {
    public int minJumpI(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        int n = array.length;
        int[] steps = new int[n];
        steps[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            final int UNREACHABLE = -1;
            if (array[i] == 0) {
                steps[i] = UNREACHABLE;
            } else if (i + array[i] >= n - 1) {
                steps[i] = 1;
            } else {
                int min = steps[i + array[i]];
                for (int j = array[i]; j >= 1; j--) {
                    if (steps[i + j] == UNREACHABLE) {
                        continue;
                    }
                    if (i + j < n) {
                        if (min == UNREACHABLE) {
                            min = steps[i + j];
                        } else {
                            min = Math.min(min, steps[i + j]);
                        }
                    }
                }
                if (min == UNREACHABLE) {
                    steps[i] = UNREACHABLE;
                } else {
                    steps[i] = min + 1;
                }
            }
        }
        return steps[0];
    }

    public int minJump(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }

        int n = array.length;
        int[] m = new int[n];
        m[0] = 0;
        for (int i = 1; i < m.length; i++) {
            m[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && m[j] != -1) {
                    if (m[i] == -1 || m[i] > m[j] + 1) {
                        m[i] = 1 + m[j];
                    }
                }
            }
        }
        return m[n - 1];
    }
}
