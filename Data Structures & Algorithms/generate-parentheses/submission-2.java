class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        generateParenthesis(n, 0, 0, sb, list);

        return list;
    }

    private void generateParenthesis(int n, int closed, int opened, StringBuilder sb, List<String> list) {
        if (closed == n) {
            list.add(sb.toString());
        }

        if (opened < n) {
            generateParenthesis(n, closed, opened + 1, sb.append("("), list);
            sb.setLength(sb.length() - 1);
        }

        if (closed < opened) {
            generateParenthesis(n, closed + 1, opened, sb.append(")"), list);
            sb.setLength(sb.length() - 1);
        }
    }
}
