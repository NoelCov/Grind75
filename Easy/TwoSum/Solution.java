class Solution {
    // Space Complexity O(n)
    // Time Complexity O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int numNeeded = target - num;

            if (map.containsKey(numNeeded)) {
                res[0] = map.get(numNeeded);
                res[1] = i;
                break;
            }

            map.put(num, i);
        }
        return res;
    }
}