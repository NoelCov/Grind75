class Solution {
    // Time Complexity O(V + E)
    // Space Complexity O(V + E)
    public boolean isBalanced(TreeNode root) {
        int res = getSubtreeHeight(root);
        return res != -1;
    }

    public int getSubtreeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getSubtreeHeight(node.left);
        int right = getSubtreeHeight(node.right);

        if (left == -1 || right == -1 || Math.abs(right - left) > 1) {
            return -1;
        }    

        return Math.max(left, right) + 1;    
    }
}