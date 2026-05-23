class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0, j = 1, n = prices.length;

        while (i < j && j < n) {
                System.out.println("i: " + i + ", p[i]: " + prices[i] + ", j: " + j + ", p[j]: " + prices[j]);
            if (prices[j] >= prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            } else {
                i++;
            }
            j++;
        }

        while (i < j) {
            if (prices[j - 1] >= prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j - 1] - prices[i]);
            }
            i++;
        }

        return maxProfit;
    }
}
