package come.class15_DP2.attempt04;

public class ArrayHopperII {
    public int minJump(int[] array) {
        final int UNREACHABLE = -1;
        int n = array.length;
        int[] minJump = new int[n];
        minJump[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (array[i] == 0) {
                minJump[i] = UNREACHABLE;
            } else if (i + array[i] >= n - 1) {
                minJump[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= array[i]; j++) {
                    if (minJump[i + j] != UNREACHABLE) {
                        min = Math.min(min, minJump[i + j]);
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    minJump[i] = UNREACHABLE;
                } else {
                    minJump[i] = min + 1;
                }
            }
        }
        return minJump[0];
    }
}
