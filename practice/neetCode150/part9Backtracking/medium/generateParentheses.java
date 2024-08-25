package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class generateParentheses {

    public static void main(String args[]) {

        generateParentheses sol = new generateParentheses();
        System.out.println(sol.generateParenthesis(3));
        System.out.println(sol.generateParenthesis(0));

    }

    private List<String> res;
    private Stack<String> stack;

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        this.res = res;
        this.stack = stack;
        backtracking(0, 0, n);
        return res;

    }

    public void backtracking(int open, int close, int n) {

        if (open == n && close == n) {

            StringBuilder str = new StringBuilder();
            for (String s : stack)
                str.append(s);

            res.add(str.toString());
            return;

        }

        if (open < n) {

            stack.add("(");
            backtracking(open + 1, close, n);
            stack.pop();

        }

        if (open > close) {

            stack.add(")");
            backtracking(open, close + 1, n);
            stack.pop();

        }

    }

}
