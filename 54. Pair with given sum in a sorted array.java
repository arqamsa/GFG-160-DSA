class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                if (arr[left] == arr[right]) {
                    int freq = right - left + 1;
                    count += (freq *(freq - 1)) / 2;
                    break;
                } else {
                    int leftCount = 1, rightCount = 1;
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                        leftCount++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                        rightCount++;
                    }
                    count += leftCount * rightCount;
                    left++;
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
