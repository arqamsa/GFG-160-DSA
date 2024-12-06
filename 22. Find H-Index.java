// User function Template for Java
class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int hIndex = n - i;
            if (citations[i] >= hIndex) {
                return hIndex;
            }
        }
        return 0;
    }
}
