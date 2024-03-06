package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class practiceReverseStackRecursion {

    static Stack<Integer> stack = new Stack<>();

    static void callStack (int x){

        if(stack.isEmpty()){
            stack.push(x);
        }
        else{

            int a = stack.pop();

            callStack(x);

            stack.push(a);
            
        }
        
    }
    
    static void recursion(){

        if (!stack.empty()){

            int a = stack.pop();            
            recursion();
            callStack(a);

        }
        else{

        }
            

    }
    
    static public void main (String args[]){

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);

        recursion();
        System.out.println(stack);
    }
}
