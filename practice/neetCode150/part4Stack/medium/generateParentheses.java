package practice.neetCode150.part4Stack.medium;

import java.util.*;

public class generateParentheses {

    public static void main (String args[]){

        System.out.println(generateParenthesis(3));
        // System.out.println(generateParenthesis(1));
        // System.out.println(generateParenthesis(0));
        
    }
    
    static List<String> res = new ArrayList<>();
    static Stack<String> stack = new Stack<>();
    public static List<String> generateParenthesis(int n) {
        
        backtracking (0, 0, n);
        return res;
        
    }
    
    public static void backtracking (int open, int close, int n) {

        if (open == n && close == n) {
            StringBuilder str = new StringBuilder();
            for (String s : stack)
                str.append(s);
            res.add(str.toString());
            return ;
        }
        if (open < n) {
            stack.add("(");
            backtracking (open + 1, close, n);
            stack.pop();
        }
        if (open > close) {
            stack.add(")");
            backtracking (open, close + 1, n);
            stack.pop();
        }

    }


    // ArrayList<String> result = new ArrayList<String>();

    // public List<String> generateParenthesis(int n) {

    //     solve(n, n, n, "");
    //     return result;

    // }
    
    // public void solve(int n, int open, int close, String str){
        
    //     if(open < 0 || close < 0)
    //         return;
    //     if(open != 0) {
    //         solve(n, open-1, close, str+'(');
    //     }
    //     if(close > open) {
    //         solve(n, open, close-1, str+')');
    //     }
    //     if(close == open && open == 0) {
    //         // solve(n, open, close-1, str+')');
    //         result.add(str);
    //     }
    
    // }

}