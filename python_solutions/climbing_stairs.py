# Time Complexity O(n)
# Space Complexity O(1)
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        arr = [1,2]
        for i in range(2, n):
            arr.append(arr[i - 1] + arr[i - 2])
        return arr[n - 1]
