class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    // Time Complexity O(n^n)
    // Space Complexity O(n * m) where m is the number of unique subsets.
    public List<List<Integer>> subsets(int[] nums) {
        recursive(nums, 0, new ArrayList<>());
        return res;
    }

    // Try to do one with a binary decision tree to improve the time complexity!
    private void recursive(int[] nums, int idx, List<Integer> curr) {
        if (!res.contains(curr)) {
            res.add(new ArrayList<>(curr));
        }

        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            recursive(nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}