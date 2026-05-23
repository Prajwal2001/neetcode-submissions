class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cur = nums[mid];
            
            if (cur == target) {
                return mid;
            }

            if (cur >= nums[l]) {
                if (target > cur || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < cur || target > nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}
