class Solution {
    // Time Complexity O(n ^ 2)
    // Space Complexity O(n);
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));

                    // Move left until number is diff than prev one
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    };

                    // Move right until number is diff than prev one
                    while (right > left && nums[right - 1] == nums[right]) {
                        right--;
                    };

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            // Move i until the number is diff.
            while(i < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return res;
    }
}