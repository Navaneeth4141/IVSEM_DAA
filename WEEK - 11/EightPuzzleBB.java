import java.util.*;

class EightPuzzleBB {

    static int N = 3;

    static class Node {
        Node parent;
        int[][] mat;
        int x, y;
        int cost;
        int level;

        Node(int[][] mat, int x, int y, int level, Node parent) {
            this.mat = new int[N][N];
            for (int i = 0; i < N; i++)
                this.mat[i] = mat[i].clone();
            this.x = x;
            this.y = y;
            this.level = level;
            this.parent = parent;
        }
    }

    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
        System.out.println();
    }

    static Node newNode(int[][] mat, int x, int y, int newX, int newY, int level, Node parent) {
        Node node = new Node(mat, newX, newY, level, parent);
        int temp = node.mat[x][y];
        node.mat[x][y] = node.mat[newX][newY];
        node.mat[newX][newY] = temp;
        return node;
    }

    static int calculateCost(int[][] initial, int[][] goal) {
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (initial[i][j] != 0 && initial[i][j] != goal[i][j])
                    count++;
        return count;
    }

    static boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    static void printPath(Node root) {
        if (root == null) return;
        printPath(root.parent);
        printMatrix(root.mat);
    }

    static void solve(int[][] initial, int x, int y, int[][] goal) {

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost + a.level));

        Node root = new Node(initial, x, y, 0, null);
        root.cost = calculateCost(initial, goal);
        pq.add(root);

        int[] row = {1, 0, -1, 0};
        int[] col = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            Node min = pq.poll();

            if (min.cost == 0) {
                printPath(min);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = min.x + row[i];
                int newY = min.y + col[i];

                if (isSafe(newX, newY)) {
                    Node child = newNode(min.mat, min.x, min.y, newX, newY, min.level + 1, min);
                    child.cost = calculateCost(child.mat, goal);
                    pq.add(child);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] initial = {
            {1, 2, 3},
            {5, 6, 0},
            {7, 8, 4}
        };

        int[][] goal = {
            {1, 2, 3},
            {5, 8, 6},
            {0, 7, 4}
        };

        int x = 1, y = 2;

        solve(initial, x, y, goal);
    }
}