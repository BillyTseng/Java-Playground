package come.class02.attempt01;

public class SearchInShiftedSortedArrayI {
    public int search(int[] array, int target) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[left] < array[mid]) {
                if (array[left] <= target && target <= array[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (array[mid] <= target && target <= array[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (array[left] == target) {
            return left;
        }

        if (array[right] == target) {
            return right;
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchInShiftedSortedArrayI solution = new SearchInShiftedSortedArrayI();
        int[] arr = new int[] {4 ,5, 6, 1, 2, 3};
        System.out.println(solution.search(arr, 1));
        // A = {3, 4, 5, 1, 2}, T = 4, return 1
        arr = new int[] {3, 4, 5, 1, 2};
        System.out.println(solution.search(arr, 4));
        // A = {1, 2, 3, 4, 5}, T = 4, return 3
        arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(solution.search(arr, 4));
        // A = {3, 5, 6, 1, 2}, T = 4, return -1
        arr = new int[] {3, 5, 6, 1, 2};
        System.out.println(solution.search(arr, 4));
        // [15,19,22,1,3,6,10,11,14],1
        arr = new int[] {15,19,22,1,3,6,10,11,14};
        System.out.println(solution.search(arr, 1));
    }
}
