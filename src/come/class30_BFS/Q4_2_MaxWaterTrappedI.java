package come.class30_BFS;

public class Q4_2_MaxWaterTrappedI {
    public int maxTrapped(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int lMax = array[left];
        int rMax = array[right];
        int result = 0;
        while (left < right) {
            lMax = Math.max(lMax, array[left]);
            rMax = Math.max(rMax, array[right]);
            if (lMax < rMax) {
                result += (lMax - array[left]);
                left++;
            } else {
                result += (rMax - array[right]);
                right--;
            }
        }
        return result;
    }
}
