import java.util.*;

class Node {
    int[] soln;
    int level;
    Node parent;
    Node(Node parent, int level, int N) {
        this.parent = parent;
        this.level = level;
        this.soln = new int[N];
        if (parent != null)
            System.arraycopy(parent.soln, 0, this.soln, 0, parent.soln.length);
    }
}

public class BinaryStringsBB2 {
    static int N = 3;
    static Queue<Node> Q = new LinkedList<>();

    static void generate(Node node) {
        if (node.level == N) {
            for (int i = 0; i < N; i++)
                System.out.print(node.soln[i]);
            System.out.print(" ");
            return;
        }
        for (int i = 0; i < 2; i++) {
            Node child = new Node(node, node.level + 1, N);
            child.soln[node.level] = i;
            Q.add(child);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(null, 0, N);
        Q.add(root);
        while (!Q.isEmpty()) {
            Node e = Q.poll();
            generate(e);
        }
    }
}