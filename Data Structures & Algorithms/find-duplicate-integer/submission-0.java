class Solution {
    public int findDuplicate(int[] nums) {
        int[] check = new int[nums.length + 1];

        for (int n : nums) {
            check[n]++;
        }

        for (int i = 1; i < check.length; i++) {
            if (check[i] > 1) {
                return i;
            }
        }

        return 0;
    }
}
