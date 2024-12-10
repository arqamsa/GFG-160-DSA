class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int nonOverlappingCount = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                lastEnd = interval[1];
                nonOverlappingCount++;
            }
        }
        return intervals.length - nonOverlappingCount;
    }
}
