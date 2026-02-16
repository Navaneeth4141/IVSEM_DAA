import java.util.LinkedList;
import java.util.Queue;

class Graph {
    int vertices;
    LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    void bfs(int startNode) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int n : adjList[node]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adjList[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(v, visited);
    }
}

public class BFSDFS {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        System.out.print("Breadth First Traversal starting from vertex 0: ");
        graph.bfs(0);

        System.out.println();
        System.out.print("Depth First Traversal starting from vertex 0: ");
        graph.DFS(0);
    }
}
