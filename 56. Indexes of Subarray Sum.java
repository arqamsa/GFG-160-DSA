class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int start = 0, currentSum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int end = 0; end<arr.length; end++) {
            currentSum += arr[end];
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }
            if (currentSum == target) {
                result.add(start+1);
                result.add(end+1);
                return result;
            }
        }
        result.add(-1);
        return result;
    }
}
