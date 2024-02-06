// ask Kishan ???

package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class infixToPrefix {
    
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

    public static void infixToPrefixFunc (String s){

        Stack <Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--){

            char c = s.charAt(i);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') && (c >= '0' && c <= '9')) result.insert(0, c);
            else if (c == ')') stack.push(c);
            else if (c == '('){

                while (stack.peek() != ')') {
                    result.insert(0, stack.pop());
                }
                stack.pop();
            }
            else{
                while (!stack.isEmpty() && (prec(c) < prec(stack.peek())) && associativity(c) == 'L') {
                    result.insert(0, stack.pop());                    
                }
                stack.push(c);
            }

            // System.out.println("stack " + stack);
            // System.out.println("result " + result);
        }

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        System.out.println(result);

    }

    public static void main (String args []){

        // infixToPrefixFunc("x+y*z/w+u"); ???
        infixToPrefixFunc("X+Y*Z/W+U");
        // infixToPrefixFunc("A*B+C/D");
        // infixToPrefixFunc("(A-B/C)*(A/K-L)");

    }
}
