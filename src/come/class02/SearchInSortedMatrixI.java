package come.class02;

import java.util.Arrays;

public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        int[] res = new int[] {-1, -1};
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return res;
        }

        int row = findRow(matrix, target);
        if (row == -1) {
            return res;
        }

        int col = findCol(matrix, target, row);
        if (col == -1) {
            return res;
        }
        res[0] = row;
        res[1] = col;
        return res;
    }

    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= matrix[mid][0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private int findCol(int[][] matrix, int target, int row) {
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return mid;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchInSortedMatrixI solution = new SearchInSortedMatrixI();
        // {{1,2,3,3,4},{4,5,6,7,10},{12,14,14,17,19},{22,22,22,24,25}}, t = 6. return {1, 2}
        int[][] matrix = new int[][] {{1,2,3,3,4},{4,5,6,7,10},{12,14,14,17,19},{22,22,22,24,25}};
        System.out.println(Arrays.toString(solution.search(matrix, 6)));
        // {{1,2,3,3,4},{4,5,6,7,10},{12,14,14,17,19},{22,22,22,24,25}}, t = 24 return {3, 3}
        System.out.println(Arrays.toString(solution.search(matrix, 24)));
    }
}
