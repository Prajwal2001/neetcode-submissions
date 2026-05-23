class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int cur = n;
        while (true) {
            if (cur == 1) {
                return true;
            }
            if (!set.add(cur)) {
                return false;
            }

            int temp = 0;
            while (cur > 0) {
                int rem = cur % 10;
                cur /= 10;
                temp += (rem * rem);
            }
            cur = temp;
        }
    }
}
