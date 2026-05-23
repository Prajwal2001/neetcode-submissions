class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0, j = 1, n = prices.length;

        while (j < n) {
            if (prices[j] >= prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            } else {
                i = j;
            }
            j++;
        }

        return maxProfit;
    }
}
