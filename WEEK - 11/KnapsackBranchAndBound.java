import java.util.*;

class Item {
    float weight;
    int value;
    Item(float weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class Node {
    int level, profit, bound;
    float weight;
    Node(int level, int profit, float weight) {
        this.level = level;
        this.profit = profit;
        this.weight = weight;
    }
}

public class KnapsackBranchAndBound {

    static int bound(Node u, int n, int W, Item[] arr) {
        if (u.weight >= W) return 0;

        int profitBound = u.profit;
        int j = u.level + 1;
        float totweight = u.weight;

        while (j < n && totweight + arr[j].weight <= W) {
            totweight += arr[j].weight;
            profitBound += arr[j].value;
            j++;
        }

        if (j < n)
            profitBound += (int)((W - totweight) * arr[j].value / arr[j].weight);

        return profitBound;
    }

    static int knapsack(int W, Item[] arr, int n) {

        Arrays.sort(arr, (a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));

        Queue<Node> Q = new LinkedList<>();
        Node u = new Node(-1, 0, 0);
        Node v;

        int maxProfit = 0;

        u.bound = bound(u, n, W, arr);
        Q.add(u);

        while (!Q.isEmpty()) {
            u = Q.poll();

            if (u.level == n - 1) continue;

            v = new Node(u.level + 1,
                    u.profit + arr[u.level + 1].value,
                    u.weight + arr[u.level + 1].weight);

            if (v.weight <= W && v.profit > maxProfit)
                maxProfit = v.profit;

            v.bound = bound(v, n, W, arr);
            if (v.bound > maxProfit)
                Q.add(v);

            v = new Node(u.level + 1, u.profit, u.weight);
            v.bound = bound(v, n, W, arr);

            if (v.bound > maxProfit)
                Q.add(v);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int W = 10;

        Item[] arr = {
            new Item(2, 40),
            new Item(3.14f, 50),
            new Item(1.98f, 100),
            new Item(5, 95),
            new Item(3, 30)
        };

        int n = arr.length;

        int maxProfit = knapsack(W, arr, n);

        System.out.println("Maximum possible profit = " + maxProfit);
    }
}