class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        // Monotonic Stack
        Stack<int[]> stack = new Stack<>();

        int i = 0;
        while (i < temperatures.length) {
            if (stack.isEmpty()) {
                stack.push(new int[]{i, temperatures[i]});
                i++;
                continue;
            } else {
                while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                    int[] pop = stack.pop();
                    result[pop[0]] = i - pop[0];
                }
                stack.push(new int[]{i, temperatures[i]});
                i++;
            }

        }

        return result;
    }
}
