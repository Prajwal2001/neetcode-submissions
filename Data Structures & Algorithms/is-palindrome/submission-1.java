class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);

            while (!((lChar >= '0' && lChar <= '9') || (lChar >= 'A' && lChar <= 'Z') || (lChar >= 'a' && lChar <= 'z'))) {
                if (l == r) {
                    break;
                }
                l++;
                lChar = s.charAt(l);
            }

            while (!((rChar >= '0' && rChar <= '9') || (rChar >= 'A' && rChar <= 'Z') || (rChar >= 'a' && rChar <= 'z'))) {
                if (r == l) {
                    break;
                }
                r--;
                rChar = s.charAt(r);
            }

            // System.out.println("lChar: " + lChar + ", rChar: " + rChar + ", " + String.valueOf(lChar).equalsIgnoreCase(String.valueOf(rChar)));

            if (!String.valueOf(lChar).equalsIgnoreCase(String.valueOf(rChar))) {
                return false;
            }

            l++;
            r--;
        } 

        return true;
    }
}
