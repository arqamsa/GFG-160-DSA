class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        if (n < k) return -1; 
        int low = getMax(arr); 
        int high = getSum(arr);
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(arr, k, mid)) {
                result = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    private static boolean isFeasible(int[] arr, int k, int maxPages) {
        int studentCount = 1; 
        int currentPages = 0;
        for (int pages : arr) {
            if (currentPages + pages > maxPages) {
                studentCount++;
                currentPages = pages;
                if (studentCount > k) {
                    return false; 
                }
            } else {
                currentPages += pages;
            }
        }
        return true; 
    }
    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int pages : arr) {
            max = Math.max(max, pages);
        }
        return max;
    }
    private static int getSum(int[] arr) {
        int sum = 0;
        for (int pages : arr) {
            sum += pages;
        }
        return sum;
        
    }
}
