class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n) In theory (n / 2) but we simplify. This is because our
    // queue will never hold more than n / 2.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                currLevel.add(curr.val);

                // Before moving on add its children left -> right
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(currLevel);
        }
        return res;
    }
}