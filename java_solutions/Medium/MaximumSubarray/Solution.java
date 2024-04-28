class Solution {
    public int maxSubArray(int[] nums) {
        // Time Complexity O(n)
        // Space Complexity O(1)
        int maxSum = nums[0], currSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];

            currSum += num;
            
            if (num > currSum) {
                currSum = num;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}