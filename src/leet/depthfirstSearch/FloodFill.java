package leet.depthfirstSearch;

import java.util.Arrays;
/* 733. Flood Fill - easy */
public class FloodFill {
    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            floodFillDfs(image, sr, sc, newColor, oldColor, visited);
        }
        return image;
    }

    private void floodFillDfs(int[][] image, int sr, int sc, int newColor, int oldColor, boolean[][] visited) {
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        visited[sr][sc] = true;

        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                int newRow = sr + rowOffset[i];
                int newCol = sc + colOffset[i];
                if (newRow < image.length && newRow >= 0 &&
                        newCol < image[0].length && newCol >= 0 &&
                        !visited[newRow][newCol]) {
                    floodFillDfs(image, newRow, newCol, newColor, oldColor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();
        int[][] input = {{1, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}};
        solution.floodFill(input, 1, 1, 2);
        for (int[] anInput : input) {
            System.out.println(Arrays.toString(anInput));
        }
    }
}
