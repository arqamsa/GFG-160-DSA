class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
