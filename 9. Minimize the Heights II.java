class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int result = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < k) 
                continue;
            int maxHeight = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            int minHeight = Math.min(arr[0] + k, arr[i] - k);
            result = Math.min(result, maxHeight - minHeight);
        }

        return result;
    }
}
