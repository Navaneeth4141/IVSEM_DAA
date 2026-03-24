import java.util.*;

public class ShortestSafeRoute {
    static final int R = 12;
    static final int C = 10;
    static int[] rowNum = {-1, 0, 0, 1};
    static int[] colNum = {0, -1, 1, 0};
    static int min_dist = Integer.MAX_VALUE;

    static boolean isValid(int x, int y) {
        return (x >= 0 && x < R && y >= 0 && y < C);
    }

    static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y) {
        return isValid(x, y) && mat[x][y] == 1 && !visited[x][y];
    }

    static void markUnsafeCells(int[][] mat) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + rowNum[k];
                        int y = j + colNum[k];
                        if (isValid(x, y) && mat[x][y] == 1) mat[x][y] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (mat[i][j] == -1) mat[i][j] = 0;
    }

    static void findShortestPathUtil(int[][] mat, boolean[][] visited, int i, int j, int dist) {
        if (j == C - 1) {
            min_dist = Math.min(min_dist, dist);
            return;
        }
        if (dist >= min_dist) return;

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + rowNum[k];
            int y = j + colNum[k];
            if (isSafe(mat, visited, x, y))
                findShortestPathUtil(mat, visited, x, y, dist + 1);
        }

        visited[i][j] = false;
    }

    static void findShortestPath(int[][] mat) {
        markUnsafeCells(mat);
        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            if (mat[i][0] == 1)
                findShortestPathUtil(mat, visited, i, 0, 0);
        }

        if (min_dist != Integer.MAX_VALUE)
            System.out.println("Length of shortest safe route is " + min_dist);
        else
            System.out.println("No safe route found");
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1,1,1,1,1,1,1,1,1,1},
            {1,0,1,1,1,1,1,1,1,1},
            {1,1,1,0,1,1,1,1,1,1},
            {1,1,1,1,0,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,1,1,1,1},
            {1,0,1,1,1,1,1,1,0,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {0,1,1,1,1,0,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,1,1,1,1,1,1}
        };

        findShortestPath(mat);
    }
}