class Node {
    int data;
    Node next;
    Node(int d) { data = d; }
}

public class MergeKLists {

    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.data < b.data) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    static Node mergeK(Node[] lists, int l, int r) {
        if (l == r) return lists[l];
        int mid = (l + r) / 2;
        Node left = mergeK(lists, l, mid);
        Node right = mergeK(lists, mid + 1, r);
        return merge(left, right);
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node[] lists = new Node[3];

        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(7);

        lists[1] = new Node(2);
        lists[1].next = new Node(5);
        lists[1].next.next = new Node(8);

        lists[2] = new Node(3);
        lists[2].next = new Node(6);
        lists[2].next.next = new Node(9);

        Node head = mergeK(lists, 0, lists.length - 1);
        print(head);
    }
}