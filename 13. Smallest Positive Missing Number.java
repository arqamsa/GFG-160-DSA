class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        for (int i = j; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val + j - 1 < n && arr[val + j - 1] > 0) {
                arr[val + j - 1] = -arr[val + j - 1];
            }
        }
        for (int i = j; i < n; i++) {
            if (arr[i] > 0) {
                return i - j + 1;
            }
        }
        return n - j + 1;
    }
}
