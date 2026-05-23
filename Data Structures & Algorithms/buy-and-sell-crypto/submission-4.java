class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 1, n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int maxProfit = 0;

        while (i < j) {
            if (prices[j] >= prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            } 
            if (prices[j] < prices[i] || j == n - 1) {
                i++;
            }
            if (j < n - 1) {
                j++;
            }
        }

        // while (i < j) {
        //     if (prices[j - 1] >= prices[i]) {
        //         maxProfit = Math.max(maxProfit, prices[j - 1] - prices[i]);
        //     }
        //     i++;
        // }

        return maxProfit;
    }
}
