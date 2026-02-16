import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class IterativePreOrder {
    Node root;

    void iterativePreorder() {
        iterativePreorder(root);
    }

    void iterativePreorder(Node node) {
        if (node == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    public static void main(String args[]) {
        IterativePreOrder tree = new IterativePreOrder();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        tree.iterativePreorder();
    }
}
