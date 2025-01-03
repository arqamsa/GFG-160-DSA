class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        HashSet<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : b) {
            if (setA.contains(num)) {
                intersectionSet.add(num);
            }
        }
        return new ArrayList<>(intersectionSet);
    }
}
