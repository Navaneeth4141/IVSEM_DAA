import java.util.ArrayList;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class IterativePostOrder {
    Node root;

    ArrayList<Integer> postOrderIterative(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                if (curr.right != null)
                    stack.push(curr.right);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (!stack.isEmpty() && curr.right == stack.peek()) {
                    stack.pop();
                    stack.push(curr);
                    curr = curr.right;
                } else {
                    result.add(curr.data);
                    curr = null;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        IterativePostOrder tree = new IterativePostOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        ArrayList<Integer> mylist = tree.postOrderIterative(tree.root);
        System.out.println(mylist);
    }
}
