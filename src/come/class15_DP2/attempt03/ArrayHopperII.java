package come.class15_DP2.attempt03;

public class ArrayHopperII {
    public int minJump(int[] input) {
        final int UNREACHABLE = -1;

        int n = input.length;
        int[] cnt = new int[n];
        cnt[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (input[i] == 0) {
                cnt[i] = UNREACHABLE;
            } else if (i + input[i] >= n - 1) {
                cnt[i] = 1;
            } else {
                int minJump = Integer.MAX_VALUE;
                for (int j = 1; j <= input[i]; j++) {
                    if (cnt[i + j] != UNREACHABLE) {
                        minJump = Math.min(minJump, cnt[i + j]);
                    }
                }
                if (minJump == Integer.MAX_VALUE) {
                    cnt[i] = UNREACHABLE;
                } else {
                    cnt[i] = minJump + 1;
                }
            }
        }
        return cnt[0];
    }
}
