class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int longest = 1;
        Arrays.sort(nums);

        int curLongest = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                curLongest++;
            } else if (nums[i - 1] == nums[i]) {
                continue;
            } else {
                curLongest = 1;
            }
            longest = Math.max(longest, curLongest);
        }

        return longest;
    }
}
