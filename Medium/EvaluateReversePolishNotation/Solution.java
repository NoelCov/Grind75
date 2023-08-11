class Solution {
    public int evalRPN(String[] tokens) {
        // The input can be represented as an Integer so that's good.
        // Division is truncated towards 0. (lower bound?)
        // tokens[i] == any operator or integer between -200 - 200
        
        // Time Complexity O(n)
        // Space Compleixty O(n)
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            int num;
            try {
                num = Integer.parseInt(curr);
                stack.push(num);
            } catch (Exception ex) {
                int first = stack.pop();
                int second = stack.pop();
                char operand = curr.charAt(0);
                stack.push(performOperation(operand, first, second));
            }
        }
        return stack.pop();
    }

    public int performOperation(char operand, int firstNum, int secondNum) {
        if (operand == '+') {
            return firstNum + secondNum;
        } else if (operand == '-') {
            return secondNum - firstNum;
        } else if (operand == '*') {
            return secondNum * firstNum;
        } else {
            return secondNum / firstNum;
        }
    } 
}