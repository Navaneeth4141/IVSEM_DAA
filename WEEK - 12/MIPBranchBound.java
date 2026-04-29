import java.util.*;

class Cat {
    String name;
    int weight;
    String character;
    Cat(String n, int w, String c) {
        name = n;
        weight = w;
        character = c;
    }
}

class Node {
    List<List<Cat>> partition;
    List<Cat> remaining;
    int score;

    Node(List<List<Cat>> p, List<Cat> r) {
        partition = p;
        remaining = r;
        score = p.size();
    }

    boolean isFeasible(List<Cat> group) {
        int weight = 0, angry = 0;
        for (Cat c : group) {
            weight += c.weight;
            if (c.character.equals("angry")) angry++;
        }
        return group.size() <= 5 && weight <= 25 && angry <= 1;
    }

    int lowerBound() {
        int angry = 0;
        for (Cat c : remaining)
            if (c.character.equals("angry")) angry++;
        return score + angry;
    }
}

public class MIPBranchBound {
    static List<List<Cat>> bestPartition = null;
    static int bestScore = Integer.MAX_VALUE;

    static void branchAndBound(Node node) {
        if (node.remaining.isEmpty()) {
            if (node.score < bestScore) {
                bestScore = node.score;
                bestPartition = node.partition;
            }
            return;
        }
        if (node.lowerBound() >= bestScore) return;

        Cat cat = node.remaining.get(0);
        List<Cat> newRemaining = node.remaining.subList(1, node.remaining.size());

        for (int i = 0; i < node.partition.size(); i++) {
            List<List<Cat>> newPartition = new ArrayList<>();
            for (List<Cat> g : node.partition)
                newPartition.add(new ArrayList<>(g));
            newPartition.get(i).add(cat);
            Node child = new Node(newPartition, newRemaining);
            if (child.isFeasible(newPartition.get(i)))
                branchAndBound(child);
        }

        List<List<Cat>> newPartition = new ArrayList<>();
        for (List<Cat> g : node.partition)
            newPartition.add(new ArrayList<>(g));
        List<Cat> newGroup = new ArrayList<>();
        newGroup.add(cat);
        newPartition.add(newGroup);
        Node child = new Node(newPartition, newRemaining);
        branchAndBound(child);
    }

    public static void main(String[] args) {
        List<Cat> cats = Arrays.asList(
                new Cat("Lily", 5, "sweet"),
                new Cat("Charlie", 7, "angry"),
                new Cat("Meowster", 6, "sweet")
        );

        Node root = new Node(new ArrayList<>(), cats);
        branchAndBound(root);

        System.out.println("Minimum Rooms: " + bestScore);
        for (List<Cat> group : bestPartition) {
            for (Cat c : group)
                System.out.print(c.name + " ");
            System.out.println();
        }
    }
}