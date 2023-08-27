class Solution {
    // Using bucket sort
    // Time Complexity O(n)
    // Space Complexity O(1) // It will always be 3 because the only values that array contains are 1 2 and 3.
    public void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int[] bucket = new int[3];
        
        for(int num : nums) {
            bucket[num]++;
        }

        int pointer = 0;
        for(int i = 0; i < nums.length; i++) {            
            while (bucket[pointer] == 0) {
                pointer++;
            }

            nums[i] = pointer;
            bucket[pointer]--;
        }
    }
}