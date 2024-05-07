# Time Complexity O(n) where n is the length of magazine
# Space Complexity O(1)
class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        if len(magazine) < len(ransomNote):
            return False
        
        arr = [0] * 26
        for char in magazine:
            arr[ord(char) - 97] += 1
        
        for char in ransomNote:
            arr[ord(char) - 97] -= 1

            if arr[ord(char) - 97] < 0:
                return False
        return True