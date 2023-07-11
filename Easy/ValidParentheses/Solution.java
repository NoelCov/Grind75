class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        char[] charArr = s.toCharArray();
        for (char curr : charArr) {
            if (!map.containsKey(curr)) {
                stack.push(curr);
            } else if (stack.isEmpty() || map.get(curr) != stack.pop()) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}