package come.class37_final;

/**
 * How to cut/split the number into a minimum number of items such that each item is equal to an integer's square value.
 * https://leetcode.com/problems/perfect-squares/description/
 */
public class Q3_PerfectSquares {
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        int[] M = new int[n + 1];
        for (int i = 1; i < M.length; i++) {
            M[i] = i;
            for (int j = 1; j * j <= i; j++) {
                M[i] = Math.min(M[i], M[i - j * j] + 1);
            }
        }
        return M[n];
    }
}
