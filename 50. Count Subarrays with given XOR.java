class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> xorFreq = new HashMap<>();
        int currentXOR = 0;
        long count = 0;
        for (int num : arr) {
            currentXOR ^= num;
            if (currentXOR == k) {
                count++;
            }
            int requiredXOR = currentXOR^k;
            if (xorFreq.containsKey(requiredXOR)) {
                count += xorFreq.get(requiredXOR);
            }
            xorFreq.put(currentXOR, xorFreq.getOrDefault(currentXOR, 0)+1);
        }
        return count;
    }
}
