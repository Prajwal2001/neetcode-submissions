class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffixProd = new int[n];
        suffixProd[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixProd[i] = suffixProd[i + 1] * nums[i];
        }

        int prod = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prod = nums[0];
                nums[0] = suffixProd[1];
            } else if (i == n - 1) {
                nums[n - 1] = prod;
            } else {
                int temp = nums[i];
                nums[i] = prod * suffixProd[i + 1];
                prod *= temp;
            }
        }

        return nums;
    }
}  
