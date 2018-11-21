package leet.Q51toQ100;

public class Q59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        int m = res.length;
        int x = 0;
        int y = 0;
        int cnt = 1;
        while (m > 0) {
            if (m == 1) {
                res[x][y] = cnt;
                break;
            }

            for (int i = 0; i < m - 1; i++) {
                res[x][y++] = cnt++;
            }
            for (int i = 0; i < m - 1; i++) {
                res[x++][y] = cnt++;
            }
            for (int i = 0; i < m - 1; i++) {
                res[x][y--] = cnt++;
            }
            for (int i = 0; i < m - 1; i++) {
                res[x--][y] = cnt++;
            }
            m -= 2;
            x++;
            y++;
        }
        return res;
    }
}
