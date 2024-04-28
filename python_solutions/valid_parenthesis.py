# Time Complexity O(n)
# Space Complexity O(1)
def isValid(self, s):
    """
    :type s: str
    :rtype: bool
    """
    stack = []
    map = {'[': ']', '{': '}', '(': ')'}

    for char in s:
        if char in map:
            stack.append(char)
        elif not stack or char != map.get(stack.pop()):
            return False
    
    return len(stack) == 0

