class Solution {
    public static int minChar(String s) {
        // Write your code here
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;
        int[] lps = computeLPS(combined);
        return s.length() - lps[lps.length - 1];
    }
    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; 
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
