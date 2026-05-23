class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqS = new int[26], freqT = new int[26];

        for (char c : s.toCharArray()) {
            freqS[c - 97]++;
        }

        for (char c : t.toCharArray()) {
            freqT[c - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqS[i] != freqT[i]) {
                return false;
            }
        }

        return true;
    }
}
