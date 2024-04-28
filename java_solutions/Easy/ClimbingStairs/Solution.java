class Solution {
    private final Map<Integer, Integer> memo = new HashMap<>();

    // Time Complexity O(n)
    // Space Complexity O(n) where n can be up to n solutions stored to not having
    // to calculate the same problem more than once.
    public int climbStairs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 1 || n == 0) {
            return 1;
        }

        int res = climbStairs(n - 1) + climbStairs(n - 2);
        if (!memo.containsKey(res)) {
            memo.put(n, res);
        }
        return res;
    }
}