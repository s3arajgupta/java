package practice.gfgListInterface.basicStack;

import java.util.Stack;
import java.util.List;

public class practice1 {

    public static void main (String args[]){

        Stack<String> stack = new Stack<>();

        stack.add("1");
        stack.add("2");
        stack.add("3");
        stack.add("4");
        stack.push("5");
        
        System.out.println(stack);
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());

        System.out.println("stackEmptyOrNot " + stack.isEmpty());

        
        

    }
    
}
