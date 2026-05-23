class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        
        generate(n, list, 0, 0, new StringBuilder());

        return list;
    }

    private void generate(int n, List<String> list, int open, int close, StringBuilder sb) {
        if (close == n) {
            list.add(sb.toString());
            return;
        }

        if (open < n) {
            generate(n, list, open + 1, close, sb.append("("));
            sb.setLength(sb.length() - 1);
        }

        if (close < open) {
            generate(n, list, open, close + 1, sb.append(")"));
            sb.setLength(sb.length() - 1);
        }
    }
}
