import java.util.*;

public class FeatureSelectionBB {
    static List<String> bestSubset = new ArrayList<>();
    static int bestScore = 0;

    static int evaluateSubset(List<String> subset) {
        return subset.size();
    }

    static void backtrack(List<String> features, int k, List<String> current, int index) {
        int score = evaluateSubset(current);
        if (score > bestScore) {
            bestScore = score;
            bestSubset = new ArrayList<>(current);
        }
        if (current.size() == k || index == features.size())
            return;
        for (int i = index; i < features.size(); i++) {
            current.add(features.get(i));
            backtrack(features, k, current, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> features = Arrays.asList(
                "Feature A","Feature B","Feature C","Feature D","Feature E",
                "Feature F","Feature G","Feature H","Feature I","Feature J"
        );
        int k = 3;
        backtrack(features, k, new ArrayList<>(), 0);
        System.out.println("Selected Features: " + bestSubset);
    }
}