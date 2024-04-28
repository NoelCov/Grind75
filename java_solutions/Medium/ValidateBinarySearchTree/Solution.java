class Solution {
    public boolean isValidBST(TreeNode root) {
        // If we do an inorder traversal, that should give us the result lol
        Stack<TreeNode> stack = new Stack<>();
        traverse(root, stack);

        TreeNode prev = stack.pop();
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val >= prev.val) {
                return false;
            }
            prev = curr;
        }
        return true;
    }

    public void traverse(TreeNode node, Stack<TreeNode> stack) {
        if (node == null) {
            return;
        }

        traverse(node.left, stack);
        stack.push(node);
        traverse(node.right, stack);
    } 
}