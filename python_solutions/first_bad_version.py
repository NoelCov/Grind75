# Time Complexity O(log n)
# Space Complexity (1)
class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        def helper(left, right):
            if left >= right:
                return left
        
            mid = left + (right - left) / 2
            if isBadVersion(mid):
                return helper(left, mid)
            else:
                return helper(mid + 1, right)
        
        return helper(0, n)
        