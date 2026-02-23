import java.util.*;

public class AllPairShortestPath {
    static final int INF = 99999;

    static void floydWarshall(int[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(dist[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0,3,6,INF,INF,INF,INF},
            {3,0,2,1,INF,INF,INF},
            {6,2,0,1,4,2,INF},
            {INF,1,1,0,2,INF,4},
            {INF,INF,4,2,0,2,1},
            {INF,INF,2,INF,2,0,1},
            {INF,INF,INF,4,1,1,0}
        };
        floydWarshall(graph);
    }
}