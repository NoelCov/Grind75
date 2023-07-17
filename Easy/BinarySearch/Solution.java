class Solution {
    // Time Complexity O(log n)
    // Space Complexity O(1)
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midNum = nums[mid];
            
            if (midNum == target) {
                return mid;
            } else if (midNum > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}