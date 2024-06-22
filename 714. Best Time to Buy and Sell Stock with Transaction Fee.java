public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] dp = new int[2]; // dp[0]은 주식을 소유하지 않은 상태, dp[1]은 주식을 소유한 상태

        dp[0] = 0;          // 첫날 주식을 소유하지 않은 상태의 이익은 0
        dp[1] = -prices[0]; // 첫날 주식을 소유한 상태의 이익은 주식을 산 가격의 음수

        for (int i = 1; i < n; i++) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee); // 주식을 팔지 않거나 팔고 수수료를 뺀 경우
            dp[1] = Math.max(dp[1], temp - prices[i]);        // 주식을 사지 않거나 새로 사는 경우          
            System.out.println("ith: " + i + ", price: " + prices[i] + ", dp[0]: " + dp[0] + ", dp[1]: " + dp[1]);
        }

        return dp[0]; // 마지막 날 주식을 소유하지 않은 상태에서의 최대 이익 반환
    }
}
