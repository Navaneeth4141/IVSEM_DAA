import java.util.*;

class NQueensBB {

    static int N = 8;

    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    static boolean solveNQueensUtil(int[][] board, int row, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == N)
            return true;

        for (int col = 0; col < N; col++) {
            if (!cols[col] && !d1[row - col + N - 1] && !d2[row + col]) {
                board[row][col] = 1;
                cols[col] = d1[row - col + N - 1] = d2[row + col] = true;

                if (solveNQueensUtil(board, row + 1, cols, d1, d2))
                    return true;

                board[row][col] = 0;
                cols[col] = d1[row - col + N - 1] = d2[row + col] = false;
            }
        }
        return false;
    }

    static boolean solveNQueens() {
        int[][] board = new int[N][N];
        boolean[] cols = new boolean[N];
        boolean[] d1 = new boolean[2 * N];
        boolean[] d2 = new boolean[2 * N];

        if (!solveNQueensUtil(board, 0, cols, d1, d2)) {
            System.out.println("No solution exists");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        solveNQueens();
    }
}