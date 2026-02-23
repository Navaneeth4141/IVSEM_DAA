public class Knapsack01 {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int profit[] = {10, 20, 30};
        int weight[] = {1, 1, 1};
        int W = 2;
        int n = profit.length;
        System.out.println("Maximum Profit is " + knapSack(W, weight, profit, n));
    }
}