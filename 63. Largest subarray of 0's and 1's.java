class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0, prefixSum = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 0 ) {
              arr[i] = -1;
            }
            prefixSum +=arr[i];
            if (prefixSum == 0) {
                maxLength = i + 1;
            }
            if (prefixSumMap.containsKey(prefixSum) ){
                int length = i - prefixSumMap.get(prefixSum);
                maxLength = Math.max(maxLength , length);
            } else {
                prefixSumMap.put(prefixSum , i) ;
            }
        }
        return maxLength;
    }
}
