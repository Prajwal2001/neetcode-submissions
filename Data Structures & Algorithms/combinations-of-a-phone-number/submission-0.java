class Solution {
    private Map<Character, List<Character>> dial = new HashMap<>();

    {
        dial.put('2', List.of('a', 'b', 'c'));
        dial.put('3', List.of('d', 'e', 'f'));
        dial.put('4', List.of('g', 'h', 'i'));
        dial.put('5', List.of('j', 'k', 'l'));
        dial.put('6', List.of('m', 'n', 'o'));
        dial.put('7', List.of('p', 'q', 'r', 's'));
        dial.put('8', List.of('t', 'u', 'v'));
        dial.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }

        getCombinations(digits, res, 0, "");

        return res;
    }

    private void getCombinations(String digits, List<String> list, int indx, String val) {
        if (val.length() == digits.length()) {
            list.add(val);
            return;
        }

        List<Character> chars = dial.get(digits.charAt(indx));

        for (char c : chars) {
            getCombinations(digits, list, indx + 1, val + c);
        }
    }
}
