public class Solution {
    public int numTilings(int N) {
        if (N == 1)
            return 1;
        if (N == 2)
            return 2;
        int mod = 1_000_000_007;
        long[] dp = new long[N + 1];
        dp[0] = 1; // base case: 1 way to tile 0-width board
        dp[1] = 1; // base case: 1 way to tile 1-width board
        dp[2] = 2; // base case: 2 ways to tile 2-width board

        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % mod;
        }

        return (int) dp[N];
    }
}
