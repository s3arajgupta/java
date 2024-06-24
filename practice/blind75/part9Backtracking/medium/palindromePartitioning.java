package practice.blind75.part9Backtracking.medium;

import java.util.*;

public class palindromePartitioning {

    public static void main(String[] args) {

        System.out.println(partition("aab"));

    }

    public static List<List<String>> result;
    public static List<String> part;

    public static List<List<String>> partition(String s) {

        if (s.equals("")) { // s.length() == 0
            result.add(new ArrayList<>());
            return result;
        }

        result = new ArrayList<>();
        part = new ArrayList<>();
        backtracking(0, part, s);
        return result;

    }

    public static void backtracking(int n, List<String> part, String s) {

        if (n >= s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int j = n; j < s.length(); j++) {
            if (isPalindrome(s, n, j)) { // n = i
                part.add(s.substring(n, j + 1));
                // System.out.println(part);
                backtracking(j + 1, part, s);
                part.remove(part.size() - 1);
            }
        }

    }

    public static boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }

}
