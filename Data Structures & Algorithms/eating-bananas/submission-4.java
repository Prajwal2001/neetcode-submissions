class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int p: piles) r = Math.max(r, p);
        int mid = 0;
        int k = r;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if (isPossible(piles, h, mid)) {
                k = Math.min(k, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return k;
    }

    private boolean isPossible(int[] piles, int h, int mid) {
        int sum = 0;

        for (int p : piles) {
            sum += (int)Math.ceil((double)p / mid);
        }

        return sum <= h;
    }
}
