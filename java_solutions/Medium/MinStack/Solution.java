class MinStack {
    List<Node> stack;

    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        Node newVal = new Node(val);
        if (stack.isEmpty() || val < getMin()) {
            newVal.min = val;
        } else {
            newVal.min = getMin();
        }
        stack.add(newVal);
    }
    
    public void pop() {
        stack.remove(getLast());
    }
    
    public int top() {
        return getLast().val;
    }
    
    public int getMin() {
        return getLast().min;
    }

    private Node getLast() {
        return stack.get(stack.size() - 1);
    }
}

class Node {
    public int val;
    public int min;

    public Node(int val) {
        this.val = val;
    }
}