class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        
        generate(n, 0, 0, "", res);

        return res;
    }

    private void generate(int tot, int opened, int closed, String exp, List<String> list) {
        if (closed == tot) {
            list.add(exp);
            return;
        }

        if (opened < tot) {
            generate(tot, opened + 1, closed, exp + "(", list);
        }

        if (closed < tot && closed < opened) {
            generate(tot, opened, closed + 1, exp + ")", list);
        }
    }
}
