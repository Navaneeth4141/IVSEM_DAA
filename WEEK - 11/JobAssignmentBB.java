import java.util.*;

class Node {
    Node parent;
    int pathCost;
    int cost;
    int workerID;
    int jobID;
    boolean[] assigned;

    public Node(int N) {
        assigned = new boolean[N];
    }
}

public class JobAssignmentBB {

    static final int N = 4;

    static Node newNode(int x, int y, boolean[] assigned, Node parent) {
        Node node = new Node(N);
        for (int j = 0; j < N; j++)
            node.assigned[j] = assigned[j];
        if (y != -1)
            node.assigned[y] = true;
        node.parent = parent;
        node.workerID = x;
        node.jobID = y;
        return node;
    }

    static int calculateCost(int[][] costMatrix, int x, int y, boolean[] assigned) {
        int cost = 0;
        boolean[] available = new boolean[N];
        Arrays.fill(available, true);

        for (int i = x + 1; i < N; i++) {
            int min = Integer.MAX_VALUE, minIndex = -1;
            for (int j = 0; j < N; j++) {
                if (!assigned[j] && available[j] && costMatrix[i][j] < min) {
                    min = costMatrix[i][j];
                    minIndex = j;
                }
            }
            if (minIndex != -1) {
                available[minIndex] = false;
                cost += min;
            }
        }
        return cost;
    }

    static void printAssignments(Node min) {
        if (min.parent == null)
            return;
        printAssignments(min.parent);
        if (min.jobID != -1)
            System.out.println("Worker " + min.workerID + " -> Job " + min.jobID);
    }

    static int findMinCost(int[][] costMatrix) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        boolean[] assigned = new boolean[N];
        Node root = newNode(-1, -1, assigned, null);
        root.pathCost = 0;
        root.cost = calculateCost(costMatrix, -1, -1, assigned);

        pq.add(root);

        while (!pq.isEmpty()) {
            Node min = pq.poll();
            int i = min.workerID + 1;

            if (i == N) {
                printAssignments(min);
                return min.cost;
            }

            for (int j = 0; j < N; j++) {
                if (!min.assigned[j]) {
                    Node child = newNode(i, j, min.assigned, min);
                    child.pathCost = min.pathCost + costMatrix[i][j];
                    child.cost = child.pathCost + calculateCost(costMatrix, i, j, child.assigned);
                    pq.add(child);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] costMatrix = {
            {9, 2, 7, 8},
            {6, 4, 3, 7},
            {5, 8, 1, 8},
            {7, 6, 9, 4}
        };

        int minCost = findMinCost(costMatrix);
        System.out.println("Minimum cost: " + minCost);
    }
}