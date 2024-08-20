package practice.neetCode150.part4Stack.medium;

import java.util.*;

public class evaluateReversePolishNotation {

    public static void main(String args[]) {

        // String [] tokens = {"2","1","+","3","*"};
        // System.out.println(evalRPN(tokens));
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(evalRPN(tokens));

    }

    public static int evalRPN(String[] tokens) {

        if (tokens.length == 0)
            return 0;

        int a, b;

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+")) {
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b + a));
                continue;
            }
            if (tokens[i].equals("-")) {
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a - b));
                continue;
            }
            if (tokens[i].equals("*")) {
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b * a));
                continue;
            }
            if (tokens[i].equals("/")) {
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a / b));
                continue;
            }
            stack.push(tokens[i]);
            System.out.println(stack);
        }

        return Integer.parseInt(stack.peek());

    }

}
