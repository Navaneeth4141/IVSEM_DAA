import java.util.*;

class Node {
    int x, y, g, h;
    Node parent;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int getF() {
        return g + h;
    }
}

public class AStar {
    public static final int[][] GRID = {
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,0,0,1,0},
            {1,1,0,0,0},
            {0,0,0,1,0}
    };

    public static final int[][] DIRS = {{-1,0},{1,0},{0,-1},{0,1}};

    public static int heuristic(int x, int y, int tx, int ty) {
        return Math.abs(tx - x) + Math.abs(ty - y);
    }

    public static List<Node> astar(int[][] grid, int sx, int sy, int tx, int ty) {
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(Node::getF));
        boolean[][] closed = new boolean[grid.length][grid[0].length];

        Node start = new Node(sx, sy);
        start.g = 0;
        start.h = heuristic(sx, sy, tx, ty);
        open.add(start);

        while (!open.isEmpty()) {
            Node current = open.poll();
            if (current.x == tx && current.y == ty) {
                List<Node> path = new ArrayList<>();
                while (current != null) {
                    path.add(current);
                    current = current.parent;
                }
                return path;
            }
            closed[current.x][current.y] = true;

            for (int[] d : DIRS) {
                int nx = current.x + d[0];
                int ny = current.y + d[1];

                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                if (grid[nx][ny] == 1 || closed[nx][ny]) continue;

                Node neighbor = new Node(nx, ny);
                neighbor.g = current.g + 1;
                neighbor.h = heuristic(nx, ny, tx, ty);
                neighbor.parent = current;
                open.add(neighbor);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int startX = 0, startY = 0;
        int targetX = 4, targetY = 4;

        List<Node> path = astar(GRID, startX, startY, targetX, targetY);

        if (path != null) {
            System.out.println("Path found:");
            for (int i = path.size() - 1; i >= 0; i--) {
                Node n = path.get(i);
                System.out.println("(" + n.x + ", " + n.y + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}