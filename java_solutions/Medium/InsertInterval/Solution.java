class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(List.of(newInterval[0], newInterval[1]));
                // Fix this or check if it works.
                List<int[]> remainderIntervals = Arrays.asList(Arrays.copyOfRange(intervals, i, intervals.length));
                for (int[] interval : remainderIntervals) {
                    result.add(List.of(interval[0], interval[1]));
                }
                return convertListToArray(result);
            } else if (newInterval[0] > intervals[i][1]) {
                result.add(List.of(intervals[i][0], intervals[i][1]));
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        result.add(List.of(newInterval[0], newInterval[1]));

        return convertListToArray(result);
    }

    public int[][] convertListToArray(List<List<Integer>> list) {
        int listSize = list.size();
        int[][] res = new int[listSize][2];
        for (int i = 0; i < listSize; i++) {
            List<Integer> curr = list.get(i);
            res[i][0] = curr.get(0);
            res[i][1] = curr.get(1);
        }
        return res;
    }
}