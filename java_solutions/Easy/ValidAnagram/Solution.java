class Solution {
    // Space compleixty O(n) where n is the number of unique character S has.
    // Time Complexity O(n + m) where n is the length of S and m is the length of T
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }

        for(int j = 0; j < t.length(); j++) {
            char currChar = t.charAt(j);

            if (!map.containsKey(currChar)) {
                return false;
            }

            int oldVal = map.get(currChar);
            if (oldVal == 1) {
                map.remove(currChar);
            } else {
                map.put(currChar, oldVal - 1);
            }    
        }

        return map.isEmpty();
    }
}