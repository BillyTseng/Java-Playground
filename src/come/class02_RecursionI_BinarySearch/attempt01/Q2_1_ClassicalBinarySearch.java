package come.class02_RecursionI_BinarySearch.attempt01;

public class Q2_1_ClassicalBinarySearch {
    public int binarySearch(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length <= 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if(target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q2_1_ClassicalBinarySearch solution = new Q2_1_ClassicalBinarySearch();
        int[] arr1 = new int[] {-3, 0, 1, 2, 3, 4, 5, 6};
        System.out.println(solution.binarySearch(arr1, -3));
        System.out.println(solution.binarySearch(arr1, -2));
        System.out.println(solution.binarySearch(arr1, 4));
    }
}
