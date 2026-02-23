import java.util.*;
public class KruskalsMST {
    static class Edge {
        int src, dest, weight;
        Edge(int s, int d, int w) {
            src = s; dest = d; weight = w;
        }
    }
    static class Subset {
        int parent, rank;
    }
    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,6));
        edges.add(new Edge(0,3,5));
        edges.add(new Edge(1,3,15));
        edges.add(new Edge(2,3,4));
        kruskals(V, edges);
    }
    private static void kruskals(int V, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            int x = findRoot(subsets, e.src);
            int y = findRoot(subsets, e.dest);
            if (x != y) {
                result.add(e);
                union(subsets, x, y);
            }
        }
        int minCost = 0;
        System.out.println("Following are the edges of the constructed MST:");
        for (Edge e : result) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
            minCost += e.weight;
        }
        System.out.println("Total Cost: " + minCost);
    }
    private static void union(Subset[] subsets, int x, int y) {
        int xroot = findRoot(subsets, x);
        int yroot = findRoot(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    private static int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
}