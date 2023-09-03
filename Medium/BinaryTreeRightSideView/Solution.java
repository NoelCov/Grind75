class Solution {
    // Time Complxity O(V + E)
    // Space Complexity O(V + E);
    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
    }

    private List<Integer> bfs(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            // We want to add the first child to the res at every level
            // we also want to add children right to left.
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if (i == 0) {
                    res.add(curr.val);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
            }
        }
        return res;
    }
}