class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return result;
        }
        Arrays.sort(arr);
        int n = arr.length;
        int closestSum = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;
        int left = 0, right = n-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum - target ) < Math.abs(closestSum - target) || (Math.abs(sum - target) == Math.abs(closestSum - target) && (arr[right] - arr[left] > maxAbsDiff))) {
                closestSum = sum;
                maxAbsDiff = arr[right] - arr[left];
                result = Arrays.asList(arr[left], arr[right]);
            }
            if (sum < target) {
                left++;
            } else{
                right--;
            }
        }
        return result;
    }
}
