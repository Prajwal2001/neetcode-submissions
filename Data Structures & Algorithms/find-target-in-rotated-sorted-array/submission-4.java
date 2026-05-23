class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            System.out.println("l: " + l + ", r: " + r + ", m: " + m);
            if (nums[m] == target) {
                return m;
            }

            if (target < nums[l]) {
                if (nums[m] < target || nums[m] >= nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] > target || nums[m] < nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            System.out.println("(after) l: " + l + ", r: " + r + ", m: " + m);
        }

        return -1;
    }
}
