class Solution {
    // Time Complexity O(V + E);
    // Space Complexity O(V + E);
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // We need to find the length of each subTree and return the longest one.
        // In the end we return the sum of the length of a subtree by getting the max
        // left and max right.
        dfs(root);
        return maxDiameter;
    }

    public int dfs(TreeNode root) {
        // We need to find the length of each subTree and return the longest one.
        // In the end we return the sum of the length of a subtree by getting the max
        // left and max right.
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int diameter = left + right;
        maxDiameter = Math.max(maxDiameter, diameter);
        return Math.max(left, right) + 1;
    }
}