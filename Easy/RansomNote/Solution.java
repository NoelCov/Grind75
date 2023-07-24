class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for(char curr : magazine.toCharArray()) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        for(char curr : ransomNote.toCharArray()) {
            if (map.containsKey(curr) && map.get(curr) > 0) {
                map.put(curr, map.get(curr) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}