# Time Complexity O(V + E)
# Space Complexity O(1)
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def helper(node):
            if node == None:
                return 0

            leftDepth = helper(node.left)
            if leftDepth < 0:
                return -1
            rightDepth = helper(node.right)
            if rightDepth < 0:
                return -1

            if abs(leftDepth - rightDepth) > 1:
                return -1
            return max(leftDepth, rightDepth) + 1

        res = helper(root)
        return res == -1