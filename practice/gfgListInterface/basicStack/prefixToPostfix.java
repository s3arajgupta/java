package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class prefixToPostfix {

    static boolean isAlphaNumeric (char c){

        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
        else return false;

    }
    
    static void prefixToPostfixFunc (String s){

        Stack<String> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--){

            char c = s.charAt(i);

            if(isAlphaNumeric(c)) stack.push(String.valueOf(c));
            else{
                String a = stack.pop();
                String b = stack.pop();
                stack.push(a + b + String.valueOf(c));
            }

            // System.out.println(c);
            // System.out.println(stack);

        }

        System.out.println(stack.peek());

    }

    public static void main (String args[]){

        prefixToPostfixFunc("*+AB-CD");
        prefixToPostfixFunc("*-A/BC-/AKL");

    }
    
}
