class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        return recursive(nums, sum / 2, 0);
    }

    private boolean recursive(int[] nums, int target, int index) {
        if (index == nums.length) return false;
        
        if (target <= 0) {
            if (target == 0) return true;
            return false;
        }
        
        String key = "" + index + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res = recursive(nums, target - nums[index], index + 1) || recursive(nums, target, index + 1);
        memo.put(key, res);
        return memo.get(key);
    }
}