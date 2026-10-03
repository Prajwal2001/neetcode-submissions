class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphas = new int[26], alphat = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphas[s.charAt(i) - 'a']++;
            alphat[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (alphas[i] != alphat[i]) {
                return false;
            }
        }

        return true;
    }
}
