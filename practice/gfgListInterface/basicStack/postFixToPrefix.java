package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class postFixToPrefix {

    static boolean isAlphaNumeric (char c){

        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
        else return false;

    }
    
    static void postFixToPrefixFunc (String s){

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++){

            char c = s.charAt(i);

            if(isAlphaNumeric(c)) stack.push(String.valueOf(c));
            else{
                String a = stack.pop();
                String b = stack.pop();
                stack.push(String.valueOf(c) + b + a);
            }

        }

        System.out.println(stack.peek());

    }

    public static void main (String args[]){

        postFixToPrefixFunc("AB+CD-*");
        postFixToPrefixFunc("ABC/-AK/L-*");

    }
    
}
