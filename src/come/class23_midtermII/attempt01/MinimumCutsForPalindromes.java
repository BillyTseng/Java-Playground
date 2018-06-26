package come.class23_midtermII.attempt01;

public class MinimumCutsForPalindromes {
    public int minCuts(String input) {
        int n = input.length();
        if (n == 0) {
            return 0;
        }
        int[] minCuts = new int[n];
        minCuts[0] = 0;
        for (int i = 1; i < minCuts.length; i++) {
            if (isPalindrome(input,0, i)) {
                minCuts[i] = 0;
                continue;
            }
            minCuts[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome(input, j + 1, i)) {
                    minCuts[i] = Math.min(minCuts[i], minCuts[j] + 1);
                }
            }
        }
        return minCuts[n - 1];
    }

    private boolean isPalindrome(String input, int start, int end) {
        while (start < end) {
            if (input.charAt(start++) != input.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public int minCutsI(String input) {
        int n = input.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        boolean[][] isPalin = new boolean[n + 1][n + 1];

        for (int end = 1; end < dp.length; end++) {
            dp[end] = end;
            for (int start = end; start >= 1; start--) {
                if (input.charAt(start - 1) == input.charAt(end - 1)) {
                    isPalin[start][end] = end - start < 2 || isPalin[start + 1][end - 1];
                }
                if (isPalin[start][end]) {
                    dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                }
            }
        }
        return dp[n] - 1;
    }

    public static void main(String[] args) {
        MinimumCutsForPalindromes solution = new MinimumCutsForPalindromes();
        System.out.println(solution.minCuts("abcbd"));
    }
}
