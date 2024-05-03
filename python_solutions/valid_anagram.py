# Time Complexity O(n)
# Space Complexity O(n)
def isAnagram(self, s, t):
    """
    :type s: str
    :type t: str
    :rtype: bool
    """
    if len(s) != len(t):
            return False

    map = {}
    for char in s:
        map[char] = map.get(char, 0) + 1
    
    for char in t:
        if char not in map:
            return False
        else:
            map[char] -= 1
    
    for value in map.values():
        if value > 0:
            return False
    return True
    