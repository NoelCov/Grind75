class Solution {
    // Time Complexity O(V + E);
    // Space Complexity O(V + E);
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode node) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }

        helper(node.left);
        helper(node.right);

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        return;
    }
}