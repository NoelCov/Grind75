class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums);
        return res;
    }

    // Time Complexity O(n! * n)
    // Space Complexity O(n)
    private void backtrack(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) continue;

            curr.add(nums[i]);
            backtrack(curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}