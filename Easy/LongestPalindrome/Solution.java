class Solution {
    public int longestPalindrome(String s) {
        // Time Complexity O(n)
        // Space Complexity O(n)
        Map<Character, Integer> map = new HashMap<>();

        for(Character curr : s.toCharArray()) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        int result = 0;
        boolean addOne = false;
        for(Integer value : map.values()) {
            if (value % 2 != 0) {
                value -= 1;
                addOne = true;
            }
            result += value;
        }

        if (addOne) {
            result += 1;
        }
        return result;
    }
}