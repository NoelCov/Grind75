class Solution {
    // Space Complexity O(n)
    // Time Complexity O(n)
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] * prefix[i - 1];
        }

        postfix[postfix.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            postfix[i] = nums[i] * postfix[i + 1];
        }

        postfix[0] = postfix[1];
        for (int i = 1; i < postfix.length - 1; i++) {
            postfix[i] = postfix[i + 1] * prefix[i - 1];
        }
        postfix[postfix.length - 1] = prefix[prefix.length - 2];
        return postfix;
    }
}