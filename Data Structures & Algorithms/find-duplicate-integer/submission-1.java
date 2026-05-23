class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            // System.out.println("slow: " + slow + ", fast: " + fast);
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                // System.out.println("slow: " + slow + ", fast: " + fast);
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            // System.out.println("slow2: " + slow2 + ", slow: " + slow);
            slow2 = nums[slow2];
            slow = nums[slow];
            if (slow == slow2) {
                // System.out.println("slow2: " + slow2 + ", slow: " + slow);
                return slow;
            }
        }
    }
}
