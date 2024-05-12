package practice.neetCode.stack.easy;

import java.util.Stack;

public class validParentheses {
    
    public static void main (String args[]){

        System.out.println(isValid("([]){}"));
        System.out.println(isValid("(()"));
        System.out.println(isValid(")"));
        
    }

    public static boolean isValid (String s){

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){

            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') stack.push(s.charAt(i));
            else {
                if (!stack.isEmpty()){
                    char top = stack.pop();
                    // System.out.println("top " + top);
                    if ((s.charAt(i) == '}' && top != '{') || (s.charAt(i) == ']' && top != '[') || (s.charAt(i) == ')' && top != '(')) return false;
                }
                else return false;
            }
        }
        System.out.println(stack);
        if (stack.size() == 0) return true; else return false;
        
    }
    
}
