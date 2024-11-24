class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        int maxSoFar = Integer.MIN_VALUE; 
        int currentMax = 0; 

        for (int num : arr) {
            currentMax += num;
            maxSoFar = Math.max(maxSoFar, currentMax);
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        
        return maxSoFar;
    }
}
