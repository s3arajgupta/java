package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class wellFormedness {

    static char complement (char c){

        if (c == ')') return '(';
        else if (c == '}') return '{';
        else if (c == ']') return '[';
        else return '0';

    }
    
    static boolean wellFormednessFunc (String s){

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == complement(c)) stack.pop();
            else stack.push(c);

            System.out.println(stack);

        }

        if (!stack.isEmpty()) return false;
        else return true;

    }

    public static void main (String args[]){

        // boolean result = wellFormednessFunc("[()]{}{[()()]()}");
        boolean result = wellFormednessFunc("[()]{}{[()()]()}[(])");
        // wellFormednessFunc("[()]{}{[()()]()}");
        System.out.println(result);

    }
}
