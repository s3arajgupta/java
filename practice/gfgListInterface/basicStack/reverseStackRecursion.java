package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class reverseStackRecursion {
    
    static Stack<Integer> stack = new Stack<>();

    static void insertAtBottom (int x){

        
        if (stack.isEmpty()) {
            stack.push(x);
            System.out.println(stack);
        }
        else{

            int a = stack.pop();
            System.out.println(stack);
            System.out.println("a: " + a);
            System.out.println("x: " + x);
            insertAtBottom(x);
            System.out.println(stack);
            stack.push(a);
            System.out.println(stack);

        }
        
    }

    static void reverseStackRecursionFunc(){

        if (!stack.isEmpty()){
            
            int a = stack.pop();
            System.out.println(stack);
            reverseStackRecursionFunc();
            System.out.println(stack);
            insertAtBottom(a);
            System.out.println(stack);

        }

    }

    public static void main (String args[]){

        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack);
        reverseStackRecursionFunc();
        System.out.println(stack);
        
    }

}
