package come.class12.attempt01;

public class ArrayHopperI {
    public boolean canJump(int[] array) {
        if (array.length == 1) {
            return true;
        }
        boolean[] canJump = new boolean[array.length];
        for (int i = canJump.length - 2; i >= 0; i--) {
            if (i + array[i] >= array.length - 1) {
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
