class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int res = recursion(coins, amount);
        if (res != Integer.MAX_VALUE) {
            return res;
        }
        return -1;
    }

    public int recursion(int[] coins, int amount) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = recursion(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        memo.put(amount, min);
        return memo.get(amount);
    }
}