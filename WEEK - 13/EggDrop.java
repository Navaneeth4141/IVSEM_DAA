import java.util.*;

class EggDrop {
    static int max(int a, int b) { return (a > b) ? a : b; }

    static int eggDrop(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int j = 1; j <= k; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int res = 1 + max(dp[i - 1][x - 1], dp[i][j - x]);
                    if (res < dp[i][j]) {
                        dp[i][j] = res;
                    }
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String args[]) {
        int n = 2, k = 36;
        System.out.println("Minimum number of trials in worst case with " + n + " eggs and " + k + " floors is " + eggDrop(n, k));
    }
}