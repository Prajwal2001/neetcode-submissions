class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] pop = stack.pop();
                result[pop[0]] = i - pop[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        return result;
    }
}
