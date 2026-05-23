class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int val1, val2;
        for (String val: tokens) {
            System.out.println(stack.toString());
            switch(val) {
                case "+":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    stack.push(val1 + val2);
                    break;
                case "-":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    System.out.println(val1 + ", " + val2);
                    stack.push(val2 - val1);
                    break;
                case "*":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    stack.push(val1 * val2);
                    break;
                case "/":
                    val1 = stack.pop();
                    val2 = stack.pop();
                    System.out.println(val1 + ", " + val2);
                    stack.push(val2 / val1);
                    break;
                default:
                    stack.push(Integer.parseInt(val));
                    break;
            }
        }

        return stack.pop();
    }
}
