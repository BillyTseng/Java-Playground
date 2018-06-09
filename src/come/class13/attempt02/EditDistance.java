package come.class13.attempt02;

public class EditDistance {
    public int editDistance(String one, String two) {
        int m = one.length();
        int n = two.length();
        int[][] dist = new int[m + 1][n + 1];

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                if (i == 0) {
                    dist[i][j] = j;
                } else if (j == 0) {
                    dist[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    dist[i][j] = Math.min(dist[i - 1][j], dist[i][j - 1]);
                    dist[i][j] = Math.min(dist[i - 1][j - 1], dist[i][j]);
                    dist[i][j] += 1;
                }
            }
        }
        return dist[m][n];
    }
}
