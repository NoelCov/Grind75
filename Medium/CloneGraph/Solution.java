class Solution {
    private Map<Node, Node> map = new HashMap<>();

    // Space Complexity O(V)
    // Time Complexity O(V + E)
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If it already exists as a clone, we return it.
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Make clone and add it to hashmap.
        Node clone = new Node(node.val);
        map.put(node, clone);

        // Repeat for children so that we can add them or link them to the clone
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}