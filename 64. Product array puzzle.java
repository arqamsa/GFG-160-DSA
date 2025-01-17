class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int[] res = new int[n];
        int zeroCount = 0, totalProd = 1;
        for (int num : arr) {
            if (num == 0)
                zeroCount++;
            else 
                totalProd *= num;
        }
        if (zeroCount > 1) 
            return res;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                res[i] = totalProd;
            else if (zeroCount == 0) 
                res[i] = totalProd / arr[i];
        }
        return res;
    }
}
