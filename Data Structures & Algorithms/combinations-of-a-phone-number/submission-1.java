class Solution {
    private Map<Integer, char[]> dial = Map.of(
        2, new char[]{'a', 'b', 'c'},
        3, new char[]{'d', 'e', 'f'},
        4, new char[]{'g', 'h', 'i'},
        5, new char[]{'j', 'k', 'l'},
        6, new char[]{'m', 'n', 'o'},
        7, new char[]{'p', 'q', 'r', 's'},
        8, new char[]{'t', 'u', 'v'},
        9, new char[]{'w', 'x', 'y', 'z'}
    );

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        StringBuilder sb = new StringBuilder();

        letterCombinations(digits, 0, sb, list);

        return list;
    }

    private void letterCombinations(String digits, int idx, StringBuilder sb, List<String> list) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        }

        char[] letters = dial.get(digits.charAt(idx) - '0');
        for (int i = 0; i < letters.length; i++) {
            letterCombinations(digits, idx + 1, sb.append(letters[i]), list);
            sb.setLength(sb.length() - 1);
        }
    }
}
