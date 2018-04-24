package come.class02;

public class LastOccurrence {
    public int lastOccur(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length <= 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] == target) {
            return right;
        } else if (array[left] == target){
            return left;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LastOccurrence solution = new LastOccurrence();
        // A = {1, 2, 3}, T = 2, return 1
        int[] arr1 = {1, 2, 3};
        System.out.println(solution.lastOccur(arr1, 2));
        // A = {1, 2, 3}, T = 4, return -1
        System.out.println(solution.lastOccur(arr1, 4));
        // A = {1, 2, 2, 2, 3}, T = 2, return 3
        arr1 = new int[] {1, 2, 2, 2, 3};
        System.out.println(solution.lastOccur(arr1, 2));
        // A = {7,7,7}, T = 7, return 2
        arr1 = new int[] {7, 7, 7};
        System.out.println(solution.lastOccur(arr1, 7));
    }
}
