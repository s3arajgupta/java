package practice.neetCode150.part9Backtracking.medium;

import java.util.*;

public class palindromePartitioning {

    public static void main(String[] args) {

        palindromePartitioning sol = new palindromePartitioning();
        System.out.println(sol.partition("aab"));
        System.out.println(sol.partition("aaba"));

    }

    private List<List<String>> result;
    private List<String> temp;
    private String s;

    public List<List<String>> partition(String s) {

        if (s.equals("")) { // s.length() == 0 // ninja
            result.add(new ArrayList<>());
            return result;
        }

        result = new ArrayList<>();
        temp = new ArrayList<>();
        this.s = s;
        backtracking(0); // focus on index
        return result;

    }

    public void backtracking(int n) {

        if (n == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int j = n; j < s.length(); j++) {
            if (isPalindrome(n, j)) { // n = i
                temp.add(s.substring(n, j + 1));
                backtracking(j + 1);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public boolean isPalindrome(int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;

    }

}
