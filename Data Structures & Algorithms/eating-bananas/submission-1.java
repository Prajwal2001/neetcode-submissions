class Solution {
    private boolean isPossible(int mid, int[] piles, int h) {
        if (mid <= 0) {
            return false;
        }
        int hours = 0;

        for (int p : piles) {
            hours += ((p / mid) + (p % mid == 0 ? 0 : 1));
        }

        // System.out.println("hours: " + hours + ", mid: " + mid);

        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r = 0;
        int rate = 0;

        for (int p: piles) {
            r = Math.max(p, r);
        }
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.println("l: " + l + ", r: " + r);
            if (isPossible(mid, piles, h)) {
                // rate = Math.max(rate, mid);
                rate = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return rate;
    }
}
