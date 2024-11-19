// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int n = arr.length;
        int k=0; //Non-Zero index
        for (int i=0; i<n; i++)
        {
            if (arr[i]!=0)
            {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k++;
            }
        }
    }
}
