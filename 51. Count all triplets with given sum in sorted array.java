class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int count = 0 ;
        int n = arr.length;
        for (int i = 0; i< n-2; i++) {
            int j = i+1;
            int k = n-1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    int e1=arr[j], e2=arr[k], c1=0, c2=0;
                    while (j<=k && arr[j]==e1) {
                        c1++;
                        j++;
                    }
                    while (j<=k && arr[k]==e2) {
                        c2++;
                        k--;
                    }
                    if (e1==e2) {
                        count += (c1*(c1-1))/2;
                    } else {
                        count += c1*c2;
                    }
                }
            }
        }
        return count;
    }
}
