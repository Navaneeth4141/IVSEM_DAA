import java.util.Vector;

class BT {

    public static void printParents(int node, Vector<Vector<Integer>> adj, int parent) {
        if (parent != 0) {
            System.out.println("Parent of " + node + " is " + parent);
        }
        for (int i = 0; i < adj.get(node).size(); i++) {
            int child = adj.get(node).get(i);
            if (child != parent) {
                printParents(child, adj, node);
            }
        }
    }

    public static void printChildren(int Root, Vector<Vector<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            System.out.print("Children of " + i + " are: ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (adj.get(i).get(j) != Root || i != Root) {
                    System.out.print(adj.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }
    }

    public static void printLeafNodes(int Root, Vector<Vector<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            if (adj.get(i).size() == 1 && i != Root) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void printDegrees(int Root, Vector<Vector<Integer>> adj) {
        for (int i = 1; i < adj.size(); i++) {
            System.out.println("Degree of " + i + " is " + adj.get(i).size());
        }
    }

    public static void main(String[] args) {
        int N = 7, Root = 1;

        Vector<Vector<Integer>> adj = new Vector<>();
        for (int i = 0; i < N + 1; i++) {
            adj.add(new Vector<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(1).add(4);
        adj.get(4).add(1);
        adj.get(2).add(5);
        adj.get(5).add(2);
        adj.get(2).add(6);
        adj.get(6).add(2);
        adj.get(4).add(7);
        adj.get(7).add(4);

        System.out.println("The parents of each node are:");
        printParents(Root, adj, 0);

        System.out.println("The children of each node are:");
        printChildren(Root, adj);

        System.out.println("The leaf nodes of the tree are:");
        printLeafNodes(Root, adj);

        System.out.println("The degrees of each node are:");
        printDegrees(Root, adj);
    }
}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinaryTree {

    Node root;

    BinaryTree() {
        root = null;
    }

    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }

    void printPreorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPostorder(Node node) {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder(tree.root);
        System.out.println();

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);
        System.out.println();

        System.out.println("Postorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }
}
