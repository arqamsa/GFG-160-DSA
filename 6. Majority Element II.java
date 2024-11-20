class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] arr) {
        // Your code goes here.
        int n = arr.length;
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) 
            result.add(candidate1);
        if (count2 > n / 3) 
            result.add(candidate2);
        result.sort(Integer::compareTo);
        return result;
    }
}
