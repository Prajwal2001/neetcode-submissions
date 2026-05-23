class Solution {
    public int reverseBits(int n) {
        
        for (int i = 0, j = 31; i < j; i++, j--) {
            boolean left = (n & (1 << j)) != 0;
            boolean right = (n & (1 << i)) != 0;
            // System.out.println("j: " + i + ", right: " + right + ", j: " + j + ", left: " + left);
            if (left != right) {
                n ^= (1 << j);
                n ^= (1 << i);
            }
        }

        return n;
    }
}
