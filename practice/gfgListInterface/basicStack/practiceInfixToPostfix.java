package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class practiceInfixToPostfix {
    
    public static int prec (char c){

        if (c == '^') return 3;
        else if (c == '*' || c == '/' ) return 2;
        else if (c == '+' || c == '-' ) return 1;
        else return -1;

    }

    public static char associativity (char c){

        if (c == '^') return 'R';
        else return 'L';
    }

    public static void infixToPostfixFunc(String s){

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) result.append(c);
            else if (c == '(') stack.push(c);
            else if (c == ')'){

                while (stack.peek() != '(') result.append(stack.pop());
                stack.pop(); 

            }
            else{
                while (!stack.isEmpty() && (prec(c) <= prec(stack.peek())) && associativity(c) == 'L'){
                    result.append(stack.pop());
                }
                stack.push(c);
            }

            System.out.println(i);
            System.out.println(stack);
            System.out.println(result);

        }

        while(!stack.isEmpty()) result.append(stack.pop());

        System.out.println(stack);
        System.out.println(result);

    }
    
    public static void main (String args[]){

        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        infixToPostfixFunc(exp);

    }
}
// abcde-^fgh*+i-^*+
// abcd^e-fgh*+^*+i-