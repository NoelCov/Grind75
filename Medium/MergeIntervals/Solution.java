class Solution {
    // Time Complexity O(n log n)
    // Space Complexity O(n)
    public int[][] merge(int[][] intervals) {
        // O(n log n) to sort
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        List<int[]> temp = new ArrayList<>();
        for(int i = 0; i < intervals.length - 1; i++) {
            if (overlap(intervals[i], intervals[i + 1])) {
                int[] newInterval = new int[] {
                    Math.min(intervals[i][0], intervals[i + 1][0]),
                    Math.max(intervals[i][1], intervals[i + 1][1])
                };
                intervals[i + 1] = newInterval;
            } else {
                temp.add(intervals[i]);
            }
        }
        temp.add(intervals[intervals.length - 1]);
        int[][] res = new int[temp.size()][2];
        for(int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private boolean overlap(int[] a, int[] b) {
        if (a[0] < b[0] && a[1] < b[0] || a[0] > b[1] && a[1] > b[1]) {
            return false;
        }
        return true;
    }
}