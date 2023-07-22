class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    // The second stack is only used as a temp stack to flip the items and make a
    // queue of it.
    // When pushing an item, since we want it to be at the bottom, we put everything
    // in the second stack
    // Push the new item to the first stack, and then return everything to the first
    // stack so it's at the bottom.
    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}