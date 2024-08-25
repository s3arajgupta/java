package practice.neetCode150.part4Stack.easy;

import java.util.Stack;

public class validParentheses {

    public static void main(String args[]) {

        System.out.println(isValid("([]){}"));
        System.out.println(isValid("(()"));
        System.out.println(isValid(")"));

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[')
                stack.push(s.charAt(i));

            else {
                if (!stack.isEmpty()) {

                    char top = stack.pop();

                    if ((s.charAt(i) == '}' && top != '{')
                            || (s.charAt(i) == ']' && top != '[')
                            || (s.charAt(i) == ')' && top != '('))
                        return false;

                } else
                    return false;
            }

        }

        if (stack.size() == 0)
            return true;
        else
            return false;

    }

}
