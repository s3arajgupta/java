package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class reverseIndividualWords {
    
    static void reverseIndividualWordsFunc (String s){

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i <= s.length() - 1; i++){

            char c = s.charAt(i);

            if (c != ' '){
                stack.push(c);
            } 
            else {
                while (!stack.isEmpty()) {
                    res.append(stack.pop());
                }
                res.append(' ');
            }
            
        }
        
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        System.out.println(res);
        
    }

    public static void main (String args[]){

        reverseIndividualWordsFunc("Hello World");

    }
}
