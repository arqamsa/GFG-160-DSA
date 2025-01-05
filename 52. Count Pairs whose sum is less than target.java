class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1, count = 0;
        while (left < right) {
            if(arr[left] + arr[right] < target) {
                count += (right-left);
                left++;
            } else {
                right--;
            }
            
        }
        return count;
    }
}
