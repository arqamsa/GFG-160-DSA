class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return 0; 
        }
        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) 
        {
            int current = arr[i];
            if (current < 0) 
            {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);
            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
