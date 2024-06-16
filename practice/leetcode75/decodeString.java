package practice.leetcode75;

import java.util.*;

public class decodeString {

    public static void main(String[] args) {

        System.out.println(decodeStringFunc("11[ab]2[bc]"));
        System.out.println(decodeStringFunc("3[a2[c]]"));
        System.out.println(decodeStringFunc("30[ab]21[bc]"));
        System.out.println(decodeStringFunc("[a]2[bc]"));
        System.out.println(decodeStringFunc("3[ab11[xy]]"));

    }

    public static String decodeStringFunc(String s) {

        Stack<String> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        StringBuilder temp = new StringBuilder();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            // System.out.println(stack);
            // str = new StringBuilder();
            // temp = new StringBuilder();

            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                countStack.add(count);
                stack.add(String.valueOf(s.charAt(i)));
                continue;
            }

            stack.add(String.valueOf(s.charAt(i)));

            if (stack.peek().equals("]")) {
                stack.pop();
                while (!stack.peek().equals("[")) {
                    temp.append(stack.pop());
                }
                stack.pop();

                int n = 1;
                if (!countStack.isEmpty())
                    n = countStack.pop();
                while (n != 0) {
                    str.append(temp);
                    n--;
                }
                stack.add(str.toString());
                temp.setLength(0);
                str.setLength(0);
            }
        }

        if (stack.isEmpty())
            return new String();
        else {
            while (!stack.isEmpty()) {
                temp.append(stack.pop());
            }
        }
        return temp.reverse().toString(); // ninja

    }

}
