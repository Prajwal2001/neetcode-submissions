class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a , b) -> a[0] - b[0]);

        Stack<Double> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            stack.push((double)(target - pairs[i][0]) / pairs[i][1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }
}
