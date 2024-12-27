class Solution {
  int countPairs(int arr[], int target) {
        // Your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        for (int num : arr) {
            int complement = target - num;
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(complement);
            }
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
