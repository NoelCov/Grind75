class Solution {
    private Map<Integer, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, 0);
    }

    private boolean backtrack(String s, List<String> wordDict, int idx) {
        if (idx >= s.length()) {
            if (idx == s.length()) return true;
            return false;
        }

        if (memo.containsKey(idx)){
            return memo.get(idx);
        }

        for(String word : wordDict) {
            String currWord;
            try {
                currWord = s.substring(idx, idx + word.length());
            } catch (Exception e) {
                continue;
            }
            if (word.equals(currWord)) {
                boolean res = backtrack(s, wordDict, idx + word.length());
                memo.put(idx, res);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }
}