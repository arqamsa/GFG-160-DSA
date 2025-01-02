class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        int n = arr.length;
        int count=0;
        int sum=0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);
        for(int i=0; i<n; i++) {
            sum+=arr[i];
            if (prefixSumMap.containsKey(sum-k)) {
                count += prefixSumMap.get(sum-k);
            }
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
