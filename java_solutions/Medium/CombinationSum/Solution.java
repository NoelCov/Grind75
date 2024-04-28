class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    // Time Complexity O(n ^ t)
    // Space Complexity O(t)
    private void recursion(List<List<Integer>> res, int[] candidates, int target, List<Integer> currCandidates, int idx) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(currCandidates));
            }
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            currCandidates.add(candidates[i]);
            recursion(res, candidates, target - candidates[i], currCandidates, i);
            currCandidates.remove(currCandidates.size() - 1);
        }
    }
}