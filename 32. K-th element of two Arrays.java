class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int mergedArray[] = new int[a.length + b.length];
        for (int i=0; i<a.length; i++) {
            mergedArray[i] = a[i];
        }
        for (int i=0; i<b.length; i++) {
            mergedArray[a.length+i] = b[i];
        }
        Arrays.sort(mergedArray);
        return mergedArray[k-1];
    }
}
