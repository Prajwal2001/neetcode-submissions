class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] checked = new boolean[n];
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                checked[i] = true;
                List<String> list = new ArrayList<>();
                String str = strs[i];
                list.add(str);

                for (int j = i + 1; j < n; j++) {
                    if (checkAnagram(str, strs[j])) {
                        checked[j] = true;
                        list.add(strs[j]);
                    }
                }

                ans.add(list);
            }
        }

        return ans;
    }

    private boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
