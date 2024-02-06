package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class postfixToInfix {

    public static void postfixToInfixFunc (String s){

        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();

        System.out.println(arr);

        for (int i = 0; i < arr.length; i++){

            if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= '0' && arr[i] <= '9')){
                stack.push(String.valueOf(arr[i]));
            }
            else {

                String a = stack.pop();
                String b = stack.pop();
                stack.push("(" + b + arr[i] + a + ")");
            }
        }

        // System.out.println(stack);
        System.out.println(result.append(stack.pop()));

    }

    public static void main (String args[]){

        String exp = "abc++";
        postfixToInfixFunc(exp);
        exp = "ab*c+";
        postfixToInfixFunc(exp);
        

    }
    
}
