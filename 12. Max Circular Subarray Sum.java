class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        if (arr == null || arr.length == 0) return 0;

        int n = arr.length;
        int maxNormalSum = kadane(arr);
        if (maxNormalSum < 0) return maxNormalSum;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i]; 
            arr[i] = -arr[i]; 
        }
        int maxInvertedSum = kadane(arr);
        int maxCircularSum = totalSum + maxInvertedSum; 
        return Math.max(maxNormalSum, maxCircularSum);
    }
    private int kadane(int[] arr) {
        int maxEndingHere = 0, maxSoFar = Integer.MIN_VALUE;
        for (int num : arr) {
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    
}
