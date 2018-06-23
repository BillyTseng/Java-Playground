package come.class12.attempt04;

public class ArrayHopperI {
    public boolean canJump(int[] input) {
        int n = input.length;
        boolean[] canJump = new boolean[n];
        canJump[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (i + input[i] >= n - 1) {
                canJump[i] = true;
            } else {
                for (int j = 1; j <= input[i]; j++) {
                    if (canJump[i + j]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }
}
