package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class prefixToInfix {

    static boolean isAlphaNumeric (char c){

        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) return true;
        else return false;

    }
    
    static void prefixToInfixFunc(String s){

        Stack<String> stack = new Stack<>();
        
        char[] arr = s.toCharArray();

        for (int i = arr.length - 1; i >= 0; i--){

            if (isAlphaNumeric(arr[i])) stack.push(String.valueOf(arr[i]));
            else{
                String a = stack.pop();
                String b = stack.pop();
                stack.push("(" + a + arr[i] + b + ")");
            }
            System.out.println(stack);

        }

        System.out.println(stack.peek());

    }

    public static void main (String args[]){

        prefixToInfixFunc("*-A/BC-/AKL");

    }
}
