# Time Complexity O(V + E)
# Space Complexity O(1)
def invertTree(self, root):
    """
    :type root: TreeNode
    :rtype: TreeNode
    """
    if root:
        root.left, root.right = root.right, root.left

        self.invertTree(root.left)
        self.invertTree(root.right)
        
    return root
    