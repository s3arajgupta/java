// The two easiest ways to convert a string to an integer in Java are to use Integer.parseInt() or Integer.valueOf() 

package practice.gfgListInterface.basicStack;

import java.util.Stack;

public class multiDigitPostFix {

    static void multiDigitPostFixFunc(String s) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == ' ') {
                stack.push(Integer.valueOf(temp.toString()));
                temp.setLength(0);
            } else if (c == '+') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
                i++;
            } else if (c == '-') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a - b);
                i++;
            } else if (c == '*') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
                i++;
            } else if (c == '/') {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
                i++;
            } else {
                temp.append(c);
            }
            
            System.out.println(temp);
            System.out.println(stack);

        }
        
        System.out.println(stack.peek());

    }

    public static void main(String args[]) {

        multiDigitPostFixFunc("100 200 + 2 / 5 * 7 +");

    }
}
