class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        if (n==0)
            return 0;
        int left = 0, right = n-1, lMax = 0, rMax = 0, trappedWater = 0;
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] < lMax)
                    trappedWater += lMax - arr[left];
                else 
                    lMax = arr[left];
                left++;
            } else {
                if (arr[right] < rMax)
                    trappedWater += rMax - arr[right];
                else 
                    rMax = arr[right];
                right--;
            }
        }
        return trappedWater;
    }
}
