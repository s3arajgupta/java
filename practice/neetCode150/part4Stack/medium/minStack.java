package practice.neetCode150.part4Stack.medium;

import java.util.Stack;

public class MinStack {

    public static void main(String args[]) {

        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.stack);
        System.out.println(obj.minStack);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

    }

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);

    }

    public void pop() {

        int toBePopped = stack.pop();

        if (toBePopped == minStack.peek())
            minStack.pop();

    }

    public int top() {

        return stack.peek();

    }

    public int getMin() {

        return minStack.peek();

    }

}
