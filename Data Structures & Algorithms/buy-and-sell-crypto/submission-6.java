class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int l = 0, r = 1;
        int max = 0;
        while (r < n) {
            if (prices[r] >= prices[l]) {
                max = Math.max(max, prices[r] - prices[l]);
                r++;
            } else {
                l = r;
            }
        }

        return max;
    }
}
