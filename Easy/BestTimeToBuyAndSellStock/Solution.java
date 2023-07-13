class Solution {
    // Time Complexity O(n)
    // Space Complexity O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currStock = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - currStock;
            if (currProfit <= 0) {
                currStock = prices[i];
            }

            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}