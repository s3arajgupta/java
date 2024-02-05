package practice.gfgListInterface.basicStack;

import java.util.*;

public class infixToPostfix {

    public static int prec (char c){

        if (c == '^') return 3;
        else if (c == '/' || c == '*') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;

    }

    public static char associativity (char c){

        if (c == '^') return 'R';
        else return 'L';

    }

    public static StringBuilder infixToPostfixFunc (String s){

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0'))
                result.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else {
                // while(!stack.isEmpty() && (prec(c) <= prec(stack.peek()))){
                while(!stack.isEmpty() && (prec(c) <= prec(stack.peek())) && associativity(c) == 'L'){
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        
        // System.out.println(result);
        // System.out.println(stack);

        return result;
        
    }

    public static void main (String args[]){

        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        StringBuilder infixToPostfixResult = infixToPostfixFunc(exp);
        System.out.println("infixToPostfixResult " + infixToPostfixResult);
        
    }
}
