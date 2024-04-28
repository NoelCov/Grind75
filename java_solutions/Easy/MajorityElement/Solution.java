class Solution {
    // Space Complexity O(1)
    // Time Complexity O(n)
    public int majorityElement(int[] nums) {
        // Using Booyer-Moore majority algorithm
        int curr = nums[0];
        int counter = 0;
        for (int num : nums) {
            if (num == curr) {
                counter++;
            } else {
                counter--;
            }

            // This means that so far, there is a number that appears as many times as the
            // current one so we start considering a new one.
            if (counter == 0) {
                curr = num;
                counter = 1;
            }
        }
        // This problem in LeetCode states that one number WILL BE the majority in the
        // array so we can assume this is the result.
        // Otherwise we would have to do another check where we count how many times
        // curr is in the array and if that number is bigger than n / 2 then it is
        // indeed our result.
        // Otherwise there is no majority number and there are multiple numbers that
        // appear the same number of times.
        return curr;
    }
}