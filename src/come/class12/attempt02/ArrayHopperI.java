package come.class12.attempt02;

public class ArrayHopperI {
    public boolean canJump(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        int n = array.length;
        boolean[] canJump = new boolean[n];
        canJump[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (i + array[i] >= n - 1) {
                canJump[i] = true;
            } else {
                for (int j = array[i]; j >= 1; j--) {
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
