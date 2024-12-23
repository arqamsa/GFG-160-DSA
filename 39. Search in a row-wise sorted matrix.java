class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length; 
        if (n == 0) return false;
        int m = mat[0].length; 
        for (int i = 0; i < n; i++) {
            if (binarySearch(mat[i], x)) {
                return true; 
            }
        }
        return false; 
    }
    private boolean binarySearch(int[] row, int x) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == x) {
                return true;
            } else if (row[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
