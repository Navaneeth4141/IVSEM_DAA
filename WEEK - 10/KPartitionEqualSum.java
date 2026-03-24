import java.util.*;

public class KPartitionEqualSum {
    static boolean solve(int[] arr, int[] subsetSum, boolean[] taken, int target, int K, int N, int idx) {
        if (subsetSum[idx] == target) {
            if (idx == K - 2) return true;
            return solve(arr, subsetSum, taken, target, K, N, idx + 1);
        }
        for (int i = 0; i < N; i++) {
            if (!taken[i]) {
                int temp = subsetSum[idx] + arr[i];
                if (temp <= target) {
                    taken[i] = true;
                    subsetSum[idx] += arr[i];
                    if (solve(arr, subsetSum, taken, target, K, N, idx)) return true;
                    taken[i] = false;
                    subsetSum[idx] -= arr[i];
                }
            }
        }
        return false;
    }

    static boolean isKPartitionPossible(int[] arr, int N, int K) {
        if (K == 1) return true;
        if (N < K) return false;

        int sum = 0;
        for (int x : arr) sum += x;
        if (sum % K != 0) return false;

        int target = sum / K;
        boolean[] taken = new boolean[N];
        int[] subsetSum = new int[K];

        Arrays.sort(arr);
        subsetSum[0] = arr[N - 1];
        taken[N - 1] = true;

        return solve(arr, subsetSum, taken, target, K, N, 0);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 3, 3};
        int N = arr.length;
        int K = 3;

        if (isKPartitionPossible(arr, N, K))
            System.out.println("Partitions into equal sum is possible.");
        else
            System.out.println("Partitions into equal sum is not possible.");
    }
}