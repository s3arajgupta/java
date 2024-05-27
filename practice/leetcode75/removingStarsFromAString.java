package practice.leetcode75;

import java.util.*;

public class removingStarsFromAString {

    public static void main(String[] args) {

        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));

    }

    public static String removeStars (String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if(!stack.empty() && s.charAt(i) == '*') {
                stack.pop();
            }
            else stack.push(s.charAt(i));

        }
        // System.out.println(stack);

        StringBuilder res = new StringBuilder();
        for (Character c : stack) res.append(c);

        return res.toString();

    }

}
