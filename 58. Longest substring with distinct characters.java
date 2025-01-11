class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        int maxLen = 0, left = 0;
        int[] chIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            chIndex[i] = -1;
        }
        for (int right = 0; right < n; right++) {
            if (chIndex[s.charAt(right)] >= left) {
                left = chIndex[s.charAt(right)] + 1;
            }
            chIndex[s.charAt(right)] = right;
            maxLen = Math.max(maxLen, right-left+1 );
        }
        return maxLen;
    }
}
