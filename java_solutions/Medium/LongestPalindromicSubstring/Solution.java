class Solution {
    // Time Complexity O(n ^ 2 + m)
    // Space Complexity O(n)

    // There is a Dynamic Programming solution that has a better time complexity
    // than this one that I want to attempt.
    public String longestPalindrome(String s) {
        String curr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                int len = j + 1 - i;
                if (isPalindrome(sub)) {
                    if (len > curr.length()) {
                        curr = sub;
                    }
                }
            }
        }
        return curr;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}