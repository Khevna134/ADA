public class pr11 {
    public static void main(String[] args) {
        int[] p = {1, 2, 3, 4};
        int n = p.length;

        int result = matrixChainOrder(p, n);
        System.out.println("Minimum number of multiplications: " + result);
    }

    static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1];
    }
}
